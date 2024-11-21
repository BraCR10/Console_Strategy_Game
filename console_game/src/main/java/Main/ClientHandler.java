package Main;

import Threads.PlayersThread;
import Warriors.Warrior;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class ClientHandler {
    
    public Socket socket;
    
    public DataOutputStream playerOut;
    public DataInputStream playerIn;
    public ObjectOutputStream playerOutObj;
   
    public String ID;
    public ArrayList<Warrior> warriors;
    public PlayersThread thread;
    
    //the idea is to receive only strings by console
    //the server will convert the string to a command with the tokenizerArgs or something similar
    //then the server will send 2 objs to the client a ICommand command and String[] Args
    //finally the client  execute it locally
    
    //NOTE: If you hae any  other idea let me know

    public ClientHandler(Socket socket) {   
        try {    
            this.socket = socket;
            this.playerOut = new DataOutputStream(this.socket.getOutputStream());
            this.playerIn = new DataInputStream(this.socket.getInputStream());
            this.playerOutObj = new ObjectOutputStream(this.socket.getOutputStream()) ;
            this.warriors = new ArrayList<>();
            
        } 
        catch (IOException e){ 
            System.out.println("[ERROR]: Client could NOT connect ( ClientHandler.java -> ClientHandeler(Socket) ) ");
        }

    }
    
    public void AddWarrior(Warrior w){
        this.warriors.add(w);
    }
    
}
