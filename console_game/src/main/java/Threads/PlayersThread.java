package Threads;

import Main.ClientHandler;
import Main.GameServer;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayersThread extends Thread{
    private GameServer server;
    private ClientHandler client;
    
    public PlayersThread(GameServer server, ClientHandler client) {
        this.server = server;
        this.client = client;
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
                client.ID = Args[1];
                System.out.println("New name registered");
                
            }
            case "crtw" -> {
                Warrior NewWarrior = new Warrior(Args);
                client.AddWarrior(NewWarrior);
                client.playerOutObj.writeObject(NewWarrior);
                
            }
            default -> System.out.println("[ERROR] : Command invalid ["+MainArg+"] (PlayersThread --> sentInfo(String))");
        }
    
    }
    
}
