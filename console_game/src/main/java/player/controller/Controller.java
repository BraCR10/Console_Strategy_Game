/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.java.player.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import src.java.player.screens.Screen;
import src.java.player.serverConnection.ServerConnectionManager;
import src.java.utils.LoadImage;

/**
 *
 * @author Brian Ramirez
 */
public class Controller  {
    private Screen playerScreen;
    private ServerConnectionManager playerData;

    public Controller(Screen playerScreen, ServerConnectionManager data) {
        this.playerScreen = playerScreen;
        this.playerData = data;
        init();
    }
    private void init() {
        playerScreen.setTitle("Console Game");
        addClickListener(playerScreen.getCard1Label());
        addClickListener(playerScreen.getCard2Label());
        addClickListener(playerScreen.getCard3Label());
        addClickListener(playerScreen.getCard4Label());
        this.playerData.connectChat(this);
        this.playerData.connectGame(this);
        setCards();
    }
    public void showScreen(){
        this.playerScreen.setVisible(true);
    
    }
    
    private void addClickListener(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicked on ");
            }
        });
    }
    private void setCards(){
        
        this.playerScreen.getCard1Label().setIcon(LoadImage.loadImageAdjusted("cards//darkMagician.jpeg", 50, 50));
        this.playerScreen.getCard2Label().setIcon(LoadImage.loadImageAdjusted("cards//darkMagician.jpeg", 50, 50));
        this.playerScreen.getCard3Label().setIcon(LoadImage.loadImageAdjusted("cards//darkMagician.jpeg", 50, 50));
        this.playerScreen.getCard4Label().setIcon(LoadImage.loadImageAdjusted("cards//darkMagician.jpeg", 50, 50));
    
    
    }
    public Screen getPlayerScreen() {
        return playerScreen;
    }

    
    
    
    
}
