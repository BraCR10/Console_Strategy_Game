package Main;

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
    public ObjectOutputStream playerOutObj;
    public DataInputStream playerIn;
   
    public String ID;
    public ArrayList<Warrior> warriors;
        
    public ClientHandler(Socket socket) {   
        try {    
            this.socket = socket;
            this.playerOut = new DataOutputStream(this.socket.getOutputStream());
            this.playerIn = new DataInputStream(this.socket.getInputStream());
            this.playerOutObj = new ObjectOutputStream(this.socket.getOutputStream()) ;
        } 
        catch (IOException e){ 
            System.out.println("[ERROR]: Client could NOT connect ( ClientHandler.java -> ClientHandeler(Socket) ) ");
        }

    }
    
}
