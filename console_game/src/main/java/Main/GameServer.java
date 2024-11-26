package Main;

import Threads.AcceptClients;
import Threads.PlayersThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import Utils.Message;
import Utils.SentPlayersInfo;


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
       
        do {
            playerTurn++;
            if (playerTurn >= players.size()){playerTurn = 0;}
          }
          while (!players.get(playerTurn).IsPlaying);
        
        
        for (ClientHandler player : players){
            player.IsMyTurn = false;
        }
        
        players.get(playerTurn).IsMyTurn = true;
        players.get(playerTurn).PLAYERoutINFO.writeUTF("Is your turn");
    }
    
    public void Check_Loser(ClientHandler player) throws IOException{

        if ((player.warriors.size() >= 4 &&
            (player.warriors.get(0).HP <= 0 &&
             player.warriors.get(1).HP <= 0 &&
             player.warriors.get(2).HP <= 0 &&
             player.warriors.get(3).HP <= 0))){

                player.Lose_Counter++;
                player.IsPlaying = false;

                player.PLAYERoutINFO.writeUTF("YOU LOST");
                player.warriors.clear();

                player.PLAYERoutINFO.writeUTF(" YOU LOST (˙◠˙) ");
                
                player.PLAYERoutINFO.writeUTF("SetMyInfo");
                player.PLAYERinObjINFO.writeObject(new SentPlayersInfo(player));
                player.PLAYERinObjINFO.writeObject(SentPlayersInfo.getList(this.players));
        }
       
        
    }
    
    public void Check_Winer(ClientHandler player) throws IOException{
        int activePlayers = 0;
        for (ClientHandler p : players){
            if(p.IsPlaying){activePlayers++;}
        }
        
        if (player.IsPlaying && activePlayers == 1){
            player.Win_Counter++;
            
            player.PLAYERoutINFO.writeUTF("WON");
            player.warriors.clear();
 
            player.PLAYERoutINFO.writeUTF("YOU WON !!!!!!!!!!!!\n--------[\\( ﾟヮﾟ)/🏆]-------");
            player.IsPlaying = false;
        }
       
        
    }
    
    public void Check_Peace() throws IOException{

        boolean all_Gave_Up = true;

        for (ClientHandler player : players){
            all_Gave_Up &= player.WantsPeace;
        } 

        if(all_Gave_Up){
            for (ClientHandler player : players){
                    player.PLAYERoutINFO.writeUTF("ALL GAVE UP");
                    
                    player.IsPlaying = false;
                    player.warriors.clear();
                    
                    player.PLAYERoutINFO.writeUTF(" YOU ALL CHOOSE ☮︎ ");
            } 
        }
            
    }
    
    public static void main(String[] args) throws IOException { new GameServer(); }
}
