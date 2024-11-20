package Main;

import Threads.AcceptClients;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import Utils.Message;

public class GameServer {
    ServerSocket server;
    ArrayList<ClientHandler> players;
    
    
    
    
    
    public GameServer() throws IOException {
        System.out.println("--------------------[LOADING NEW GAME]--------------------");
        
        server = new ServerSocket(123); 
        players = new ArrayList<>();
        new AcceptClients(this).start();
 
    }

    public void AcceptPlayers() throws IOException{
        players.add(new ClientHandler(server.accept()));
        System.out.println("NEW PLAYER ACCEPTED !!!!");
    }
     //Currently i am using main server
     //BroadCoast funtion for chat
     public void broadCoast(Message msj){
        
        for (ClientHandler player : players) {
            try {
                player.playerOutObj.writeObject(msj);
            } catch (IOException ex) {
                System.out.println("Unable to send a broadcoast message");
            }
        }
    
    }
     public void privateMsg(Message msg){
        
        for (ClientHandler player : players) {
            try {
                if(player.ID.equals(msg.receptorID))
                player.playerOutObj.writeObject(msg);
            } catch (IOException ex) {
                System.out.println("Unable to send a broadcoast message");
            }
        }
    
    }
    public static void main(String[] args) throws IOException { new GameServer(); }
}
