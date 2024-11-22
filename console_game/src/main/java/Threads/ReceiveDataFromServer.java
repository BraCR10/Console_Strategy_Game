package Threads;

import Armaments.Armaments;
import Controller.ClientController;
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
                    case "ReceiveATTACK" -> {
                        
                        Armaments arm = (Armaments) client.playerData.inObjINFO.readObject();
                        client.ReceiveDAMAGE(arm);
                        

                    } 
                    
                    case "ReceiveMSG" -> {
                        
                        String msg = client.playerData.inINFO.readUTF();
                        //client.ReceiveMSG(msg);

                    } 
                    
                    case "ReceivePMSG" -> {
                        
                        String msg = client.playerData.inINFO.readUTF();
                        //client.ReceivePMSG(msg);

                    }   
                    
                    default -> System.out.print("..."+arg+"...");
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
