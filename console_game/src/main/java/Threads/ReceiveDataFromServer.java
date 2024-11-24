package Threads;

import Armaments.Armaments;
import Controller.ClientController;
import Utils.Message;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReceiveDataFromServer extends Thread{

    ClientController client;

    public ReceiveDataFromServer(ClientController client) {
        this.client = client;
        this.start();
    }
    
    @Override
    public void run(){
        while(true){
            try {
                
                String arg = client.playerData.inINFO.readUTF();
                
                switch (arg) {
                    case "ReceiveATTACK" -> {
                        
                        Armaments arm = (Armaments) client.playerData.inObjINFO.readObject();
                        String sender = client.playerData.inINFO.readUTF();
                        String character = client.playerData.inINFO.readUTF();
                        String weapon = client.playerData.inINFO.readUTF();
                        String affinity = client.playerData.inINFO.readUTF();
                        
                        int wins = client.playerData.inINFO.readInt();
                        int losses = client.playerData.inINFO.readInt();
                        int kills = client.playerData.inINFO.readInt();
                        int success = client.playerData.inINFO.readInt();
                        int failed = client.playerData.inINFO.readInt();
                        int giveup = client.playerData.inINFO.readInt();
                        client.displayStats(wins,losses,kills,success,failed,giveup);
                        client.ReceiveDAMAGE(arm,sender,character,weapon,affinity);
                        client.setCards();
                        client.writeConsoleln("You were attacked...");
                        
                    } 
                    
                    case "ReceiveMSG","ReceivePMSG" -> {

                        Message msg = (Message)client.playerData.inObjINFO.readObject();
                        client.displayMsg(msg.toString());

                    } 
                    
                    default -> client.writeConsoleln("// "+arg+" //");
                }
                
   
            } catch (IOException ex) {
                System.out.println("[ERROR]: Player could NOT Receive Data From the Server ( ReceiveDataFromServer.java -> run() ) ");
                Logger.getLogger(AcceptClients.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReceiveDataFromServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
