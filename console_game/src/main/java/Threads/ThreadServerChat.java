/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Main.GameServer;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import utils.Message;

/**
 *
 * @author Brian Ramirez
 */
public class ThreadServerChat extends Thread{
    public Socket socket;
    private GameServer server;
    public ObjectOutputStream output;
    public DataInputStream inputData;
    public ObjectInputStream input;
    String playerName;
    private  boolean  isRunning;

    public ThreadServerChat(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
        isRunning=true;
        try {
            output=new ObjectOutputStream(socket.getOutputStream());
            inputData= new DataInputStream(socket.getInputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            //todo
        }
        
    }

    @Override
    public void run() {
        Message msg;

       
        while (isRunning) {
            try {
                
                msg = (Message) input.readObject();
                if(msg.type == Message.MessageType.PUBLIC)
                    server.broadCoast(msg);
                else if(msg.type == Message.MessageType.PRIVATE)
                        server.broadCoast(msg);
            } catch (IOException ex) {
                //a player lost connection TODO
            } catch (ClassNotFoundException ex) {
                //a player lost connection TODO
            }
            
        }
    }
}
