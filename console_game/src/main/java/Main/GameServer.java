package Main;

import Threads.AcceptClients;
import Threads.ThreadConnectionChat;
import Threads.ThreadServerChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import utils.Message;

public class GameServer {
    ServerSocket server;
    ArrayList<ClientHandler> players;
    
    
    //for chat services
    private final int CHAT_PORT = 3006;
    public ServerSocket serverSocketChat;
    public ArrayList<ThreadServerChat> playersChat;
    ThreadConnectionChat threadConnectionsListener;
    
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

     //BroadCoast funtion for chat
     public void broadCoast(Message msj){
        
        for (ThreadServerChat player : playersChat) {
            try {
                player.output.writeObject(msj);
            } catch (IOException ex) {
                System.out.println("Unable to send a broadcoast message");
            }
        }
    
    }
     public void privateMsg(Message msj){
        
        for (ThreadServerChat player : playersChat) {
            try {
                //if(player.)
                player.output.writeObject(msj);
            } catch (IOException ex) {
                System.out.println("Unable to send a broadcoast message");
            }
        }
    
    }
    public static void main(String[] args) throws IOException { new GameServer(); }
}
