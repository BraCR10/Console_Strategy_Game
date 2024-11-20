/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player.serverConnection;

import player.controller.ClientController;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
    public ObjectOutputStream outObj;
    
    public String playerID;
    //tread player
    ThreadClientListener thread;
    
    
    
    public ClientConnectionManager(){
        //temp
        playerID="Juan";
    }
    
    //For game services
    public void connectGame(ClientController controller) throws IOException {
            this.socketPlayerGame = new Socket("localhost", GAME_PORT);
            this.out = new DataOutputStream(socketPlayerGame.getOutputStream());
            this.in = new DataInputStream(socketPlayerGame.getInputStream());
    }


    public Socket getPlayerConnection() {
        return socketPlayerGame;
    }
    
    
    
}
