package ServerConnections;

import Armaments.Armaments;
import Controller.ClientController;
import Warriors.Warrior;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientConnectionManager {
    //Server
    private final int GAME_PORT = 123;
    private final int CONNECTION_PORT = 124;
    
    protected Socket socketPlayerGame;
    protected Socket socketConnection;
    
    
    public DataInputStream in;
    public DataOutputStream out;
    public ObjectInputStream inObj;
    
    
    public DataInputStream inINFO;
    public DataOutputStream outINFO;
    public ObjectInputStream inObjINFO;
    
    
    
    //Todo: define how to get this data
    public String playerID;
    public ArrayList<Warrior> warriors;
    
    
    //tread player
   
    
    
    public ClientConnectionManager(){
        this.warriors = new ArrayList<>();
        this.playerID = "";
    }
    
    //For game services
    public void connectGame(ClientController controller) throws IOException {
        
        this.socketPlayerGame = new Socket("localhost", GAME_PORT);
        
        this.out = new DataOutputStream(socketPlayerGame.getOutputStream());
        this.in = new DataInputStream(socketPlayerGame.getInputStream());
        this.inObj= new ObjectInputStream(socketPlayerGame.getInputStream()); 
        
        
        this.socketConnection = new Socket("localhost", CONNECTION_PORT);
        
        this.outINFO = new DataOutputStream(socketConnection.getOutputStream());
        this.inINFO = new DataInputStream(socketConnection.getInputStream());
        this.inObjINFO = new ObjectInputStream(socketConnection.getInputStream());
               
    }

    public Socket getPlayerConnection() {
        return socketPlayerGame;
    }
    
    public void RA(){
        for(Warrior w : warriors){
            w.RechargeArm();
        }
    }
    
    public void ReceiveDAMAGE(Armaments ARM){
        for (Warrior w : warriors){
            w.ReceiveDmg(ARM);
        }   
    }
    
    
    
    
    
}
