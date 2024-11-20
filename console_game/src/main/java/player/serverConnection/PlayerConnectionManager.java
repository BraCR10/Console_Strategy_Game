/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player.serverConnection;

import player.controller.Controller;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Brian Ramirez
 */
public class PlayerConnectionManager {
    //Server
    
    private final int GAME_PORT = 123;
    protected Socket socketPlayerGame;
    
    private final int CHAT_PORT = 3000;
    protected Socket socketPlayerChat;
    
    public DataInputStream in;
    public DataOutputStream out;
    public ObjectOutputStream outObj;
    
    public String namePlayer;
    //tread player
    ThreadPlayerGame thread;
    
    
    
    public PlayerConnectionManager(){
        //temp
        namePlayer="Juan";
    }
    

    //For chat services
    public void connectChat(Controller controller) throws IOException  {
            socketPlayerChat = new Socket("localhost", CHAT_PORT);
            outObj = new ObjectOutputStream(socketPlayerChat.getOutputStream());
            out = new DataOutputStream(socketPlayerChat.getOutputStream());
            ThreadPlayerChat t = new ThreadPlayerChat(this.socketPlayerChat,controller);
            t.start();
    }
    //For game services
    public void connectGame(Controller controller) throws IOException {
            this.socketPlayerGame = new Socket("localhost", GAME_PORT);
            this.out = new DataOutputStream(socketPlayerGame.getOutputStream());
            this.in = new DataInputStream(socketPlayerGame.getInputStream());
    }

    public Socket getSocketPlayerChat() {
        return socketPlayerChat;
    }

    public Socket getPlayerConnection() {
        return socketPlayerGame;
    }
    
    
    
}
