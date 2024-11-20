/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player.serverConnection;

import utils.Message;
import player.controller.Controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadPlayerChat extends Thread{
    private boolean isRunning;
    private Socket socket;
    private Controller controller;
    private ObjectInputStream input;

    public ThreadPlayerChat(Socket socket, Controller controller) {
        this.socket = socket;
        this.controller = controller;
        isRunning=true;
        try {
            input=new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadPlayerChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        Message msg;
        while(isRunning){
            try {
                msg = (Message) input.readObject();
                String oldText=controller.getPlayerScreen().getChatBoxTextArea().getText();
                controller.getPlayerScreen().getChatBoxTextArea().setText(oldText+"\n"
                        +"----------------------------------------------------------------------------"
                        +"\n"+msg.toString());
            } catch (IOException ex) {
                Logger.getLogger(ThreadPlayerChat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadPlayerChat.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
    }
    
    
    
}