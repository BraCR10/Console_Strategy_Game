package Threads;

import Main.GameServer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AcceptClients extends Thread {
    GameServer server;

    public AcceptClients(GameServer server) {
        this.server = server;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                server.AcceptPlayers();
            } catch (IOException ex) {
                System.out.println("[ERROR]: Player could NOT connect ( AcceptClients.java -> run() ) ");
                Logger.getLogger(AcceptClients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
