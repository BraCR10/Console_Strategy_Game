package Controller;

import Armaments.Armaments;
import Commands.CommandManager;
import Commands.ICommand;
import java.io.IOException;


import javax.swing.JTextArea;
import Screens.ClientGameScreen;
import ServerConnections.ClientConnectionManager;
import Threads.ReceiveDataFromServer;
import Utils.LoadImage;
import Warriors.Warrior;
 
public class ClientController  {
    public ClientGameScreen playerScreen;
    public ClientConnectionManager playerData;
    public Warrior WarriorSelected;
    
    //console variables
    private int consoleLastPrintedPosition = 0;//to collect the current command int the text area 
    private String userConsolePrompt = "";//a user in the console
    
    //screen settings
    private final int CART_WIDTH=120;
    private final int CART_HEIGHT=200;
    private CommandManager manager;

    ReceiveDataFromServer DataFromServer;
    
    public ClientController(ClientGameScreen playerScreen, ClientConnectionManager data) {
        this.playerScreen = playerScreen;
        this.playerData = data;
        this.userConsolePrompt = playerData.playerID+"$ ";
        this.manager = new CommandManager();
        init();
        
        DataFromServer = new ReceiveDataFromServer(this);
    }
    
    public void SetuserConsolePrompt(String str){
        this.userConsolePrompt = str+"$ ";
    }
    
    private void init() {
        playerScreen.setTitle("Console Game");
        this.writeConsoleln("Console initialized | Enter your ID and Cards : ");//first prompt
 
        try {
            this.playerData.connectGame(this);
        } catch (IOException ex) {
            writeConsoleln("Sorry the server is down!!!! [ServerConnectionManager.java -> connectGame(Controller)]");        }
        
        setCards();
    
        addKeyListenerConsole();
    
    }
    
    public void showScreen(){
        this.playerScreen.setVisible(true);
    }
    

    public void ReceiveDAMAGE(Armaments ARM){
        
        String[] data=new String[this.playerScreen.getTableLastAttackReceived().getRowCount()];
        int count=0;
        for (Warrior w : this.playerData.warriors){
            w.ReceiveDmg(ARM);
            
            if(count < data.length){
                data[count]=w.getName()+"_-"+ARM.getDamage(w.affinitiy);
            }
            count++;
        }   
        displayDataAttaked(data);
        setCards();
        
    }
     public void displayDataAttaked(String[] data){
        for (int i = 0; i < this.playerScreen.getTableLastAttackReceived().getRowCount(); i++) {
            if(data[i]!=null){
                 String[] dataSplited = data[i].split("_");
                this.playerScreen.getTableLastAttackReceived().setValueAt(dataSplited[0],i,0);
                this.playerScreen.getTableLastAttackReceived().setValueAt(dataSplited[1],i,1);
            }
        }
        
    }
    
    public void setCards(){//temp function
        String str = getCardName(0);
        String hp = getCardHP(0);

        this.playerScreen.getCard1Label().setIcon(LoadImage.loadImageAdjusted("/cards//"+str+".png", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard1AvgTextField().setText(hp);
        
        str = getCardName(1);
        hp = getCardHP(1);
        this.playerScreen.getCard2Label().setIcon(LoadImage.loadImageAdjusted("/cards//"+str+".png", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard2AvgTextField().setText(hp);
        
        str = getCardName(2);
        hp = getCardHP(2);
        this.playerScreen.getCard3Label().setIcon(LoadImage.loadImageAdjusted("/cards//"+str+".png", CART_WIDTH,CART_HEIGHT));
        this.playerScreen.getCard3AvgTextField().setText(hp);
        
        str = getCardName(3);
        hp = getCardHP(3);
        this.playerScreen.getCard4Label().setIcon(LoadImage.loadImageAdjusted("/cards//"+str+".png", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard4AvgTextField().setText(hp);
    }

    public void setEmptyCards(){

        this.playerScreen.getCard1Label().setIcon(LoadImage.loadImageAdjusted("/cards//back.png", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard1AvgTextField().setText("");
        
        this.playerScreen.getCard2Label().setIcon(LoadImage.loadImageAdjusted("/cards//back.png", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard2AvgTextField().setText("");
        
        this.playerScreen.getCard3Label().setIcon(LoadImage.loadImageAdjusted("/cards//back.png", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard3AvgTextField().setText("");
        
        this.playerScreen.getCard4Label().setIcon(LoadImage.loadImageAdjusted("/cards//back.png", CART_WIDTH, CART_HEIGHT));
        this.playerScreen.getCard4AvgTextField().setText("");
    
        
        this.playerScreen.getCardPomptTextField().setText("");
        this.playerScreen.setTableCardStatsEMPTY();
    }
    
    
    private String getCardName(int index){
        try {
            return this.playerData.warriors.get(index).getName();
        } catch (Exception e) {
            return "back";
        }
    }

    private String getCardHP(int index){
        try {
            return this.playerData.warriors.get(index).HP+"%";
        } catch (Exception e) {
            return "0%";
        }
    }
    
    public Warrior getWarrior(String name){
        for(int i = 0; i < 4; i++){
            if(name.toLowerCase() == null ? this.playerData.warriors.get(i).getName().toLowerCase() == null : name. toLowerCase().equals(this.playerData.warriors.get(i).getName().toLowerCase())){
                return this.playerData.warriors.get(i);
            }  
        }
        return null;
    }   
      public void writeConsoleln(String text) {
        JTextArea consoleTextArea = this.playerScreen.getConsoleTextArea();
        
        if(text.isEmpty())
            consoleTextArea.append("\n"+ userConsolePrompt);//adapting to avoid delete user prompt
        else
            consoleTextArea.append("\n [Message] : " + text + "\n"+userConsolePrompt);
        consoleTextArea.setCaretPosition(consoleTextArea.getDocument().getLength());
        consoleLastPrintedPosition = consoleTextArea.getText().length(); 
    }
    
    private void addKeyListenerConsole() {
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
                    selectCommmand(command);
                } catch (IOException ex) {
                    writeConsoleln("The command \"" + command + "\" was not sent due to an error.");
                }
            }
        });
    }
    
    public ClientGameScreen getPlayerScreen() {
        return playerScreen;
    } 
    
    private void selectCommmand(String arg){
        String[] Args = arg.split("-");
        String MainArg = Args[0].toLowerCase();
                        
        ICommand command = manager.getCommand(MainArg);   
        command.execute(Args, this);
        
    }
    public void displayMsg(String msg){
        String old =playerScreen.getChatBoxTextArea().getText();
        if(old.isEmpty())
            playerScreen.getChatBoxTextArea().setText(old+msg);
        else
            playerScreen.getChatBoxTextArea().setText(old+"\n"+msg);
    }
    
    
}
