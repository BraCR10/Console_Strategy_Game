package player.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


import javax.swing.JLabel;
import javax.swing.JTextArea;
import player.screens.Screen;
import player.serverConnection.ServerConnectionManager;
import utils.LoadImage;

public class Controller  {
    private Screen playerScreen;
    private ServerConnectionManager playerData;
    
    //console variables
    private int consoleLastPrintedPosition = 0;//to collect the current command int the text area 
    private String userConsolePrompt;//a user in the console
    
    //screen settings
    private final int CART_WIDTH=120;
    private final int CART_HEIGHT=200;

    public Controller(Screen playerScreen, ServerConnectionManager data) {
        this.playerScreen = playerScreen;
        this.playerData = data;
        this.userConsolePrompt= data.namePlayer+"$ ";
        init();
    }
    private void init() {
        playerScreen.setTitle("Console Game");
        this.writeConsoleln("Console initialized | User: "+this.playerData.namePlayer);//first prompt
        addClickListener(playerScreen.getCard1Label());
        addClickListener(playerScreen.getCard2Label());
        addClickListener(playerScreen.getCard3Label());
        addClickListener(playerScreen.getCard4Label());
        
        
        try {
            this.playerData.connectChat(this);
            this.playerData.connectGame(this);
        } catch (IOException ex) {
            writeConsoleln("Sorry the server is down!!!! [ServerConnectionManager.java -> connectGame(Controller)]");        }
        
        setCards();
        addEnterKeyListenerConsole();
        }
    
    public void showScreen(){
        this.playerScreen.setVisible(true);
    }
    
    private void addClickListener(JLabel label) {//adding listener to the cards
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                writeConsoleln("Clicked on "+e.getClass().getName());
            }
        });
    }
    
    private void setCards(){//temp function
        this.playerScreen.getCard1Label().setIcon(LoadImage.loadImageAdjusted("/cards//Back.jpg", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard2Label().setIcon(LoadImage.loadImageAdjusted("/cards//Back.jpg", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard3Label().setIcon(LoadImage.loadImageAdjusted("/cards//Pandemonium.png", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard4Label().setIcon(LoadImage.loadImageAdjusted("/cards//Pandemonium.png", CART_WIDTH, CART_HEIGHT));

    }
   
    public void writeConsoleln(String text) {
        JTextArea consoleTextArea = this.playerScreen.getConsoleTextArea();
        if(text.isEmpty())
            consoleTextArea.append("\n"+ userConsolePrompt  );//adapting to avoid delete user prompt
        else
            consoleTextArea.append("\n\n Message: " + text+ "\n\n" + userConsolePrompt);
        consoleTextArea.setCaretPosition(consoleTextArea.getDocument().getLength());
        consoleLastPrintedPosition = consoleTextArea.getText().length(); 
    }

    private void addEnterKeyListenerConsole() {
        JTextArea consoleTextArea = this.playerScreen.getConsoleTextArea();

        consoleTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                
                //user enter 
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    evt.consume(); 
                    handleCommand();
                }
                
                //avoiding elimination of user prompt 
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE 
                    || evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
                    if (consoleTextArea.getText().endsWith(userConsolePrompt)) {
                        evt.consume(); 
                    }
                }
            }

            private void handleCommand() {
                
                String fullText = consoleTextArea.getText();
                String command = fullText.substring(consoleLastPrintedPosition).trim();

                consoleLastPrintedPosition = fullText.length();

                if (command.startsWith(userConsolePrompt)) //delete prompt to server
                   command = command.substring(userConsolePrompt.length()).trim();
 
                if (!command.isEmpty() && !command.equals("clear"))
                    sendCommandToServer(command); 
                else if(command.equals("clear"))//cleaning the screen
                    consoleTextArea.setText("");
                
                writeConsoleln("");
            }

            private void sendCommandToServer(String command) {
                try {
                    playerData.out.writeUTF(command); 
                } catch (IOException ex) {
                    writeConsoleln("The command \"" + command + "\" was not sent due to an error.");
                }
            }
        });
    }
    
    public Screen getPlayerScreen() {
        return playerScreen;
    }
    
    
}
