package Threads;

import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;
import Strategy.None;
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
                    
                    client.ReceiveDAMAGE(ARM);
                    
                    server.PassTurn();
                    
                }
            }
            
            case "cht" -> {

                msg.SetMSG(Args[1]);
                msg.isPrivate(false);
                
                for(ClientHandler c : server.players){
                    c.playerOut.writeUTF("ReceiveMSG");
                    c.PLAYERinObjINFO.writeObject(msg);
                }
            }
            
            case "cpr" -> {

                if (Tools.Check_ReceiverExists(server, client, Args)){
                    client.playerOut.writeBoolean(true);
                    ClientHandler rec = server.getClient(Args[1]);
            
                    msg.SetMSG(Args[2]);
                    msg.isPrivate(true);

                    rec.playerOut.writeUTF("ReceivePMSG");
                    rec.PLAYERinObjINFO.writeObject(msg);
                
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
            
            default -> System.out.println("[ERROR] : Command invalid ["+MainArg+"] (PlayersThread --> sentInfo(String))");
        }
    
    }
    
    private Strategy setStrategy(String Arg){
        switch (Arg.toLowerCase()) {
            case "rd" -> {return new RandomDuplex();}
            default -> {return new None();}
        }
    }
    
}
