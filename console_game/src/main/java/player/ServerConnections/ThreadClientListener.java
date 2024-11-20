/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player.ServerConnections;

import Commands.ICommand;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import Player.Controller.ClientController;
import Utils.Message;

/**
 *
 * @author Brian Ramirez
 */
public class ThreadClientListener extends Thread{
    private boolean isRunning;
    private Socket socket;
    private ClientController controller;
    private ObjectInputStream input;

    public ThreadClientListener(Socket socket, ClientController controller) {
        this.socket = socket;
        this.controller = controller;
        isRunning=true;
        try {
            input=new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadClientListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        ICommand command;
        String[] ARGS;
        while(isRunning){
            try {
                command = (ICommand) input.readObject();
                ARGS=(String[]) input.readObject();
                command.execute(ARGS);
            } catch (IOException ex) {
                Logger.getLogger(ThreadClientListener.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadClientListener.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
    }
}
