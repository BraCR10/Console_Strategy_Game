package Strategy;

import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;

public class None implements Strategy {

    @Override
    public Armaments doStrategy(String[] Args, GameServer server, ClientHandler player) {
        
        Armaments arm = player.getArmament(Args[2].toLowerCase(), Args[3].toLowerCase());
        if (arm != null){arm.CanBeUsed = false;}
        return arm;
        
    }
}