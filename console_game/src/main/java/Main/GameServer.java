package Main;

import Threads.AcceptClients;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

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

    
    public static void main(String[] args) throws IOException { new GameServer(); }
}
