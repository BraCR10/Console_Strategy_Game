/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Main.GameServer;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author Brian Ramirez
 */
public class ThreadConnectionChat extends Thread{
    private boolean  isRunning=true;
    GameServer server;


    public ThreadConnectionChat(GameServer server) {
        this.server = server;
    }
    
    
    public void run(){
        while(isRunning){
            try {
                //server.pantalla.write("waiting players");
                System.out.println("Waiting for players");
                Socket socket = server.serverSocketChat.accept();
                ThreadServerChat t = new ThreadServerChat(socket, server);
                t.start();
                server.playersChat.add(t);

            } catch (IOException ex) {
                //todo
            }
        }
    
    }
}
