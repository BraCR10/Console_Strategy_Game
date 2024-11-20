package Main;

import Threads.StrategyTimer;
import Warriors.Warrior;
import java.util.ArrayList;
import player.controller.Controller;
import player.screens.Screen;
import player.serverConnection.PlayerConnectionManager;

public class GameClient {
       
    public String ID;
    public ArrayList<Warrior> warriors;
    
    StrategyTimer timer;
    Controller screenController;
    
    
    public GameClient() throws InterruptedException {
        
        warriors = new ArrayList<>();
                 
        screenController = new Controller(new Screen(),new PlayerConnectionManager());
        screenController.showScreen();

    }


    public static void main(String[] args) throws InterruptedException { new GameClient(); }

}
