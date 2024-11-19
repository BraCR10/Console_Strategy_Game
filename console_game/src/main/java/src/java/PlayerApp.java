/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.java;

import src.java.player.Controller;
import src.java.player.Screen;
import src.java.player.ServerConnectionManager;

/**
 *
 * @author Brian Ramirez
 */
public class PlayerApp {
    
    public static void main(String[] args) {
        Controller screenController = new Controller(new Screen(),new ServerConnectionManager());
        screenController.showScreen();
    }
}
