package player.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import player.screens.Screen;
import player.serverConnection.ServerConnectionManager;
import utils.LoadImage;

public class Controller  {
    private Screen playerScreen;
    private ServerConnectionManager playerData;
    
    //screen settings
    private final int CART_WIDTH=120;
    private final int CART_HEIGHT=200;

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
        
        this.playerScreen.getCard1Label().setIcon(LoadImage.loadImageAdjusted("/cards/darkMagician.jpeg", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard2Label().setIcon(LoadImage.loadImageAdjusted("/cards//darkMagician.jpeg", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard3Label().setIcon(LoadImage.loadImageAdjusted("/cards//darkMagician.jpeg", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard4Label().setIcon(LoadImage.loadImageAdjusted("/cards//darkMagician.jpeg", CART_WIDTH, CART_HEIGHT));
    
    
    }
    public Screen getPlayerScreen() {
        return playerScreen;
    }

    
}
