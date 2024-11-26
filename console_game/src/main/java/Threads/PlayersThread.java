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
import Utils.SentPlayersInfo;
import Utils.Tools;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.Tool;

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
        
        String[] Args = args.trim().split("-");
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

                    Strategy stra = setStrategy(Args[4]);
                    Armaments ARM = stra.doStrategy(Args, server, client);
                    
                    //----------------------------------------------------------
                    Opponent.PLAYERoutINFO.writeUTF("ReceiveATTACK");              
                    
                    Opponent.PLAYERinObjINFO.writeObject(ARM);
                    
                    String message = "YOU WERE ATTACKED BY.: "+client.ID+"\n"
                            +"WARRIOR.: "+Args[2]+" - "+Args[3]+"\n"
                            +"STR.: "+stra.getToStr();

                    Opponent.PLAYERoutINFO.writeUTF(message);
                    
                    Opponent.ReceiveDAMAGE(ARM,client);
                    //----------------------------------------------------------
                    
                    client.PLAYERoutINFO.writeUTF("SentATTACK");
                    
                    message = "YOU ATTACKED.: "+Args[1]+"\n"
                            +"WARRIOR.: "+Args[2]+" - "+Args[3]+"\n"
                            +"STR.: "+stra.getToStr();
                    
                    client.PLAYERoutINFO.writeUTF(message);
                    
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
                
                else if("myturn".equals(Args[1].toLowerCase())){

                    client.playerOut.writeBoolean(client.IsMyTurn);
                }
                
            }
            
            case "sp" -> {
                
                if(Tools.Check_ReceiverExists(server, client, Args)){
                    client.playerOut.writeBoolean(true);
                    
                    ClientHandler rec = server.getClient(Args[1]);
                    

                    client.playerOutObj.writeObject(new SentPlayersInfo(rec));
                    
                } else {
                    client.playerOut.writeBoolean(false);

                } 
            }
            
            default -> System.out.println("[ERROR] : Command invalid ["+MainArg+"] (PlayersThread --> sentInfo(String))");
        }
        
        END_ACTION_AND_SENT_PLAYERS_INFO();
    
    }
    
    private void END_ACTION_AND_SENT_PLAYERS_INFO() throws IOException{
        client.PLAYERoutINFO.writeUTF("SetMyInfo");
        client.PLAYERinObjINFO.writeObject(new SentPlayersInfo(client));
        client.PLAYERinObjINFO.writeObject(SentPlayersInfo.getList(server.players));
    
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
    
}
