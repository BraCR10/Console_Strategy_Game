package Main;

import Armaments.Armaments;
import Threads.PlayersThread;
import Threads.StrategyTimer;
import Warriors.Warrior;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class ClientHandler {
    
    public Socket socket;
    
    public DataInputStream playerIn;
    public DataOutputStream playerOut;
    public ObjectOutputStream playerOutObj;
   
    public Socket socketConnection;
    
    public DataInputStream PLAYERinINFO;
    public DataOutputStream PLAYERoutINFO;
    public ObjectOutputStream PLAYERinObjINFO;
            
    public StrategyTimer timer;
    
    public String ID = "";
    public boolean IsMyTurn = false;
    public ArrayList<Warrior> warriors;
    public PlayersThread thread;

    public ClientHandler(Socket socket) {   
        try {    
            this.socket = socket;
            this.playerOut = new DataOutputStream(this.socket.getOutputStream());
            this.playerIn = new DataInputStream(this.socket.getInputStream());
            this.playerOutObj = new ObjectOutputStream(this.socket.getOutputStream()) ;
            this.warriors = new ArrayList<>();
            this.timer = new StrategyTimer();
            
        } 
        catch (IOException e){ 
            System.out.println("[ERROR]: Client could NOT connect ( ClientHandler.java -> ClientHandeler(Socket) ) ");
        }
    }
    
    public void setSerialCommunication(Socket socket){
        try {    
            this.socketConnection = socket;
            this.PLAYERoutINFO = new DataOutputStream(this.socketConnection.getOutputStream());
            this.PLAYERinINFO = new DataInputStream(this.socketConnection.getInputStream());
            this.PLAYERinObjINFO = new ObjectOutputStream(this.socketConnection.getOutputStream());
            
        } 
        catch (IOException e){ 
            System.out.println("[ERROR]: Client could NOT connect ( ClientHandler.java -> ClientHandeler(Socket) ) ");
        }
    
    }
    
    public void AddWarrior(Warrior w){
        this.warriors.add(w);
    }
    
    public boolean WeaponsLeft(){
        boolean state = false;
        
        int num = warriors.size();
        if (num > 4) {num = 4;}
        
        for (int index = 0; index < num; index++){
            state = state || (warriors.get(index).WeaponsLeft() && warriors.get(index).HP > 0);
        }
        
        return state;
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

    public Armaments getArmament(String warrior, String Arm){
        
        for (Warrior war : warriors){
        
            if(warrior.toLowerCase().equals(war.getName().toLowerCase())){

                return war.getArm(Arm);
            }
        
        }
        
        return null;
    }
    

}
