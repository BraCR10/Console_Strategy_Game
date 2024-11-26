package Threads;

import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;
import Strategy.Average;
import Strategy.BestCombo;
import Strategy.None;
import Strategy.Optimal;
import Strategy.RandomComb;
import Strategy.RandomDuplex;
import Strategy.Strategy;
import Utils.Message;
import Utils.Tools;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayersThread extends Thread{
    private GameServer server;
    private ClientHandler client;
    
    private Message msg;
    
    public PlayersThread(GameServer server, ClientHandler client) {
        this.server = server;
        this.client = client;
        
        this.msg = new Message(client.ID);
    }
    
    @Override
    public void run(){
        while(true){
            
            try {
                String args = client.playerIn.readUTF();
                sentInfo(args);
            } 
            
            catch (IOException ex) {
                System.out.println("[ERROR]: Player could NOT connect ( PlayersThread.java -> run() ) ");
                Logger.getLogger(AcceptClients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    private void sentInfo(String args) throws IOException{
        
        String[] Args = args.split("-");
        String MainArg = Args[0].toLowerCase();
        

        switch (MainArg) {
            
            case "setid" -> {
                
                if(Tools.Check_SetID(server, client, Args)){
                    client.playerOut.writeBoolean(true);
                    client.ID = Args[1];
                    
                } else {
                    client.playerOut.writeBoolean(false);

                }

            }
            
            case "selw" -> {
                if(Tools.Check_SelW(server, client, Args)){
                    client.playerOut.writeBoolean(true);}
                else {
                    client.playerOut.writeBoolean(false);}
            }
            
            case "crtw" -> {
                
                if(Tools.Check_CrtW(server, client, Args)){
                    client.playerOut.writeBoolean(true);
                    
                    Warrior NewWarrior = new Warrior(Args);
                    
                    client.AddWarrior(NewWarrior);
                    client.playerOutObj.writeObject(NewWarrior);
                
                } else {
                    client.playerOut.writeBoolean(false);
                    
                }
                

                
            }

            case "crb" -> {
                
                if(Tools.Check_CRB(server, client, Args)){
                    client.playerOut.writeBoolean(true);
                    
                    int nums = Integer.parseInt(Args[1]);
                    Tools RandomNamePicker = new Tools(Warrior.names);
                    
                    for (int i = 0; i < nums; i++){
                        
                        Warrior NewWarrior = new Warrior(RandomNamePicker.getNextName());
                        client.AddWarrior(NewWarrior);
                        client.playerOutObj.writeObject(NewWarrior);  

                    }
                    

                
                } else {
                    client.playerOut.writeBoolean(false);
                    
                }
                

                
            }
            
            case "atk" -> {

                if (!Tools.Check_IsMyTurn(server, client, Args)){client.playerOut.writeBoolean(false);
                    client.playerOut.writeUTF("[ERROR] : Error is NOT your turn....");
                }
                                                
                else if (!Tools.Check_ReceiverExists(server, client, Args)){client.playerOut.writeBoolean(false);
                    client.playerOut.writeUTF("[ERROR] : Error Opponent NOT found....");
                }

                else if (!Tools.Check_CanUseStr(server, client, Args)){client.playerOut.writeBoolean(false);
                    client.playerOut.writeUTF("[ERROR] : You CANT use strategies, right now....");
                }
                
                else if (!Tools.Check_CanUseWarrior(server, client, Args)){client.playerOut.writeBoolean(false);
                    client.playerOut.writeUTF("[ERROR] : Warrior unavailable");
                }
                
                else if (!Tools.Check_CanUseWeapons(server, client, Args)){client.playerOut.writeBoolean(false);
                    client.playerOut.writeUTF("[ERROR] : Weapon unavailable");
                }
                
                else {
                    ClientHandler Opponent = server.getClient(Args[1]);
                    
                    
                    client.playerOut.writeBoolean(true);
                    
                    
                    Opponent.PLAYERoutINFO.writeUTF("ReceiveATTACK");

                    
                    Strategy stra = setStrategy(Args[4]);
                    Armaments ARM = stra.doStrategy(Args, server, client);
                                  
                    Opponent.PLAYERinObjINFO.writeObject(ARM);
                    Opponent.PLAYERoutINFO.writeUTF(client.ID);//who sends
                    Opponent.PLAYERoutINFO.writeUTF(Args[2]);//character
                    Opponent.PLAYERoutINFO.writeUTF(Args[3]);//weapon
                    for (int i = 0; i < client.warriors.size(); i++) {
                        if(client.warriors.get(i).getName().toLowerCase().equals(Args[2])){
                            Opponent.PLAYERoutINFO.writeUTF(client.warriors.get(i).getAffinity());//affinity
                        }
                    }
                    int damage=Opponent.ReceiveDAMAGE(ARM);
                    client.playerOut.writeInt(damage);//total damage done
                    
                    //wins and losses
                    if(damage>100){
                        int wins = client.clientStats.get("wins");
                        client.clientStats.put("wins",wins+1);
                    }else{
                        int losses = client.clientStats.get("losses");
                        client.clientStats.put("losses",losses+1);
                    }
                    //warriors deleted
                    for (int i = 0; i < Opponent.warriors.size(); i++) {
                        if(Opponent.warriors.get(i).HP==0){
                            int kills = client.clientStats.get("kills");
                            client.clientStats.put("kills",kills+1);
                        }
                    }
                     //always sending stats to client
                    client.playerOut.writeInt(client.clientStats.get("wins"));
                    client.playerOut.writeInt(client.clientStats.get("losses"));
                    client.playerOut.writeInt(client.clientStats.get("kills"));
                    client.playerOut.writeInt(client.clientStats.get("success"));
                    client.playerOut.writeInt(client.clientStats.get("failed"));
                    client.playerOut.writeInt(client.clientStats.get("giveup"));
                    
                    //always sending stats of the opponet to client
                    client.playerOut.writeInt(Opponent.clientStats.get("wins"));
                    client.playerOut.writeInt(Opponent.clientStats.get("losses"));
                    client.playerOut.writeInt(Opponent.clientStats.get("kills"));
                    client.playerOut.writeInt(Opponent.clientStats.get("success"));
                    client.playerOut.writeInt(Opponent.clientStats.get("failed"));
                    client.playerOut.writeInt(Opponent.clientStats.get("giveup"));
                    client.playerOut.writeUTF(Opponent.ID);
                    
                    //always sending stats to opponent
                    Opponent.PLAYERoutINFO.writeInt(Opponent.clientStats.get("wins"));
                    Opponent.PLAYERoutINFO.writeInt(Opponent.clientStats.get("losses"));
                    Opponent.PLAYERoutINFO.writeInt(Opponent.clientStats.get("kills"));
                    Opponent.PLAYERoutINFO.writeInt(Opponent.clientStats.get("success"));
                    Opponent.PLAYERoutINFO.writeInt(Opponent.clientStats.get("failed"));
                    Opponent.PLAYERoutINFO.writeInt(Opponent.clientStats.get("giveup"));
     
                    server.PassTurn();
                    
                }
            }
            
            case "cht" -> {

                Message MSG = new Message(client.ID, client.ID, Args[1], Message.MessageType.PUBLIC);
                
                for(ClientHandler c : server.players){
                    c.PLAYERoutINFO.writeUTF("ReceiveMSG");
                    c.PLAYERinObjINFO.writeObject(MSG);
                }
            }
            
            case "cpr" -> {

                if (Tools.Check_ReceiverExists(server, client, Args)){
                    client.playerOut.writeBoolean(true);
                    ClientHandler rec = server.getClient(Args[1]);
                    
                    Message MSG = new Message(client.ID, rec.ID, Args[2], Message.MessageType.PRIVATE);
                    
                   

                    rec.PLAYERoutINFO.writeUTF("ReceivePMSG");
                    rec.PLAYERinObjINFO.writeObject(MSG);
                
                } else {
                    client.playerOut.writeBoolean(false);
                    
                }
            
            }

            case "pass" -> {
                if (Tools.Check_IsMyTurn(server, client, Args)){
                    client.playerOut.writeBoolean(true);
                    server.PassTurn();}
                
                else{
                    client.playerOut.writeBoolean(false);} 
                
            }
            
            case "ra" ->{
                if (!client.WeaponsLeft()){
                    client.RA();
                    client.playerOut.writeBoolean(true);}
                else{client.playerOut.writeBoolean(false);}  
            }
            
            case "ask" -> {
                
                if("players".equals(Args[1].toLowerCase())){
                    
                    String list = " - ";
                    
                    for (ClientHandler c : server.players){
                        if (!"".equals(c.ID) && c.ID != null){
                            list += c.ID+" - ";
 
                        }

                    }
                    client.playerOut.writeUTF(list);
                }
                
                else if("str".equals(Args[1].toLowerCase())){
                    
                    String msg = "You Can Use An STRATEGY in ["+client.timer.getTimeRemaining()+"]";
                    client.playerOut.writeUTF(msg);
                }
            }
            
            default -> System.out.println("[ERROR] : Command invalid ["+MainArg+"] (PlayersThread --> sentInfo(String))");
        }

    
    }
    
    private Strategy setStrategy(String Arg){
        switch (Arg.toLowerCase()) {
            case "avg" -> {return new Average();}
            case "bc" -> {return new BestCombo();}
            case "op" -> {return new Optimal();}
            case "rc" -> {return new RandomComb();}
            case "rd" -> {return new RandomDuplex();}
            default -> {return new None();}
        }
    }
    
    private String[] generateInfoToClientAttack(){
    
    
    return new String[MIN_PRIORITY];
    }
    
}
