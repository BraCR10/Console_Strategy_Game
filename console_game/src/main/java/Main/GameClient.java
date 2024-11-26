package Main;


import Controller.ClientController;
import Screens.ClientGameScreen;
import ServerConnections.ClientConnectionManager;

public class GameClient {
    ClientController screenController;
    
    
    public GameClient() throws InterruptedException {        
        screenController = new ClientController(new ClientGameScreen(),new ClientConnectionManager());
        screenController.showScreen();
    }


    public static void main(String[] args) throws InterruptedException { new GameClient(); }

}
