package Main;

import Threads.StrategyTimer;
import Warriors.Warrior;
import java.util.ArrayList;
import player.controller.ClientController;
import player.screens.ClientGameScreen;
import player.serverConnection.ClientConnectionManager;

public class GameClient {
       
    
    public ArrayList<Warrior> warriors;
    StrategyTimer timer;
    ClientController screenController;
    
    
    public GameClient() throws InterruptedException {
        
        warriors = new ArrayList<>();
                 
        screenController = new ClientController(new ClientGameScreen(),new ClientConnectionManager());
        screenController.showScreen();

    }


    public static void main(String[] args) throws InterruptedException { new GameClient(); }

}
