/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player.ServerConnections;

import Player.Controller.ClientController;
import Threads.StrategyTimer;
import Warriors.Warrior;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Brian Ramirez
 */
public class ClientConnectionManager {
    //Server
    
    private final int GAME_PORT = 123;
    protected Socket socketPlayerGame;
    
    
    public DataInputStream in;
    public DataOutputStream out;
    public ObjectInputStream inObj;
    
    //Todo: define how to get this data
    public String playerID;
    public ArrayList<Warrior> warriors;
    StrategyTimer timer;
    
    //tread player
    ThreadClientListener thread;
    
    
    
    public ClientConnectionManager(){
        //temp
        playerID="Juan";
        this.warriors=new ArrayList<>();
    }
    
    //For game services
    public void connectGame(ClientController controller) throws IOException {
            this.socketPlayerGame = new Socket("localhost", GAME_PORT);
            this.out = new DataOutputStream(socketPlayerGame.getOutputStream());
            this.in = new DataInputStream(socketPlayerGame.getInputStream());
            this.inObj= new ObjectInputStream(socketPlayerGame.getInputStream());
            
    }


    public Socket getPlayerConnection() {
        return socketPlayerGame;
    }
    
    
    
}
