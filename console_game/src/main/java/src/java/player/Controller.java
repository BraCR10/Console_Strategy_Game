/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.java.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author Brian Ramirez
 */
public class Controller  {
    private Screen playerScreen;
    private ServerConnectionManager data;

    public Controller(Screen playerScreen, ServerConnectionManager data) {
        this.playerScreen = playerScreen;
        this.data = data;
        init();
    }
    private void init() {
        playerScreen.setTitle("Console Game");
        addClickListener(playerScreen.getCard1Label());
        addClickListener(playerScreen.getCard2Label());
        addClickListener(playerScreen.getCard3Label());
        addClickListener(playerScreen.getCard4Label());
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

 
    
    
    
}
