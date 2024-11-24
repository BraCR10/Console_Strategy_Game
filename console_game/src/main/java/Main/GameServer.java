package Main;

import Threads.AcceptClients;
import Threads.PlayersThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import Utils.Message;


public class GameServer {
    ServerSocket server;
    ServerSocket serverCONNECTIONS;
   
    int playerTurn = 0;
    public ArrayList<ClientHandler> players;
    
    public GameServer() throws IOException {
        System.out.println("--------------------[LOADING NEW GAME]--------------------");
        
        server = new ServerSocket(123); 
        serverCONNECTIONS = new ServerSocket(124);
        
        players = new ArrayList<>();
        
        new AcceptClients(this).start();
    }

    public void AcceptPlayers() throws IOException{
        ClientHandler client = new ClientHandler(server.accept());
        
        client.setSerialCommunication(serverCONNECTIONS.accept());
        
        if(players.isEmpty()){client.IsMyTurn = true;}
        players.add(client);

        client.thread = new PlayersThread(this, client);
        client.thread.start();
        
        System.out.println("NEW PLAYER ACCEPTED !!!!");
    }    


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
    
    public ClientHandler getClient(String ID){
        for(ClientHandler player : players){
            if(ID == null ? player.ID == null : ID.equals(player.ID)){return player;}
        }
        return null;
    }
    
    public void PassTurn() throws IOException{
        playerTurn++;
        if (playerTurn >= players.size()){playerTurn = 0;}
        
        for (ClientHandler player : players){
            player.IsMyTurn = false;
        }
        
        players.get(playerTurn).IsMyTurn = true;
        players.get(playerTurn).PLAYERoutINFO.writeUTF("Is your turn");
    }
    
    public static void main(String[] args) throws IOException { new GameServer(); }
}
