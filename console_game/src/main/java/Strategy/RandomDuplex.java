package Strategy;

import Affinities.Affinities;
import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;
import Utils.Tools;


public class RandomDuplex implements Strategy {

    @Override
    public Armaments doStrategy(String[] Args, GameServer server, ClientHandler player) {
        
        Armaments arm = player.getArmament(Args[2], Args[3]);
        Affinities A = Tools.getRandomEnum(Affinities.class);
        
        
        int var = arm.getAffinity().get(A);
        var = var *2;
        arm.getAffinity().replace(A, var);
        
        
        player.timer.StartTimer();
        return arm;
        
    }
    
}
