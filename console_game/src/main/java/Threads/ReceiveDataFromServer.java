package Threads;

import Armaments.Armaments;
import Controller.ClientController;
import Utils.Message;
import Utils.SentPlayersInfo;
import java.io.IOException;
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
                    case "SentATTACK" -> {
                        
                        String display = client.playerData.inINFO.readUTF();
                        this.client.playerScreen.getLastAttackSentTextArea().setText(display);
                        this.client.playerScreen.getTotalDamageTextField().setText(String.valueOf(client.playerData.inINFO.readInt()));
                    
                    }
                    
                    case "ReceiveATTACK" -> {
                        
                        Armaments arm = (Armaments) client.playerData.inObjINFO.readObject();
                        client.ReceiveDAMAGE(arm);
                        
                        String display = client.playerData.inINFO.readUTF();
                        this.client.playerScreen.getLastAttackReceivedTextArea().setText(display);
                        
                        client.setCards();
                        client.writeConsoleln("You were attacked...");
                        
                    } 
                    
                    case "ReceiveMSG","ReceivePMSG" -> {

                        Message msg = (Message)client.playerData.inObjINFO.readObject();
                        client.displayMsg(msg.toString());

                    } 
                    
                    case "SetMyInfo" -> {
                        
                        SentPlayersInfo data = (SentPlayersInfo) client.playerData.inObjINFO.readObject();
                        this.client.playerScreen.setTableMyStatus(data);
                        
                        SentPlayersInfo[] rankings = (SentPlayersInfo[]) client.playerData.inObjINFO.readObject();
                        this.client.playerScreen.setTableRankings(rankings);
                    }
                    
                    case "YOU LOST" -> {
                        client.playerData.warriors.clear();
                        client.writeConsoleln(client.playerData.inINFO.readUTF());
                        client.setEmptyCards();
                    }
                    
                    case "Peace" -> {
                        client.writeConsoleln(client.playerData.inINFO.readUTF());              
                    }
                    
                    case "ALL GAVE UP" -> {
                        client.playerData.warriors.clear();
                        client.writeConsoleln(client.playerData.inINFO.readUTF());
                        client.setEmptyCards();
                    }  
                    
                    
                    case "WON" -> {
                        client.playerData.warriors.clear();
                        client.setEmptyCards();
                        client.writeConsoleln(client.playerData.inINFO.readUTF());
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
