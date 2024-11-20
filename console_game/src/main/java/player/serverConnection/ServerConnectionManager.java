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
public class ServerConnectionManager {
    //Server
    
    private final int GAME_PORT = 123;
    protected Socket socketPlayerGame;
    
    private final int CHAT_PORT = 3006;
    protected Socket socketPlayerChat;
    
    protected DataInputStream in;
    protected DataOutputStream out;
    protected ObjectOutputStream outObj;
    
    //Character data
    private String playerName; 
    private int playerID; 
    
    //tread player
    ThreadPlayerGame thread;
    
    
    public ServerConnectionManager(){}
    

    //For chat services
    public void connectChat(Controller controller) {
         try {
            socketPlayerChat = new Socket("localhost", CHAT_PORT);
            outObj = new ObjectOutputStream(socketPlayerChat.getOutputStream());
            out = new DataOutputStream(socketPlayerChat.getOutputStream());
            ThreadPlayerChat t = new ThreadPlayerChat(this.socketPlayerChat,controller);
            t.start();
         } catch (IOException ex) {
            System.out.println("Sorry the chat is down!!!! [ServerConnectionManager.java -> connectChat(Controller)] ");
         }


    }
    //For game services
    public void connectGame(Controller controller) {
         try {
            this.socketPlayerGame = new Socket("localhost", GAME_PORT);
            this.out = new DataOutputStream(socketPlayerGame.getOutputStream());
            this.in = new DataInputStream(socketPlayerGame.getInputStream());
         } catch (IOException ex) {
             System.out.println("Sorry the server is down!!!! [ServerConnectionManager.java -> connectGame(Controller)]");
         }


    }

    public Socket getSocketPlayerChat() {
        return socketPlayerChat;
    }

    public Socket getPlayerConnection() {
        return socketPlayerGame;
    }
    
    
    
}
