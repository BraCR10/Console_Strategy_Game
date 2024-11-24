package Strategy;

import Affinities.Affinities;
import Affinities.Affinity;
import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;
import Utils.Tools;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RandomDuplex implements Strategy {

    @Override
    public Armaments doStrategy(String[] Args, GameServer server, ClientHandler player) {
        
        Armaments BaseWeapon = player.getArmament(Args[2], Args[3]);
        if (BaseWeapon != null){BaseWeapon.CanBeUsed = false;}
        
        Armaments arm = new Armaments(BaseWeapon);
        
        Affinities A = Tools.getRandomEnum(Affinities.class);


        int var = arm.getAffinity().get(A);
        var = var *2;
        arm.getAffinity().replace(A, var);
        
        player.timer.startTimer();
        
        try {player.PLAYERoutINFO.writeUTF("Strategy [RandomDuplex] : 2x("+Affinity.getString(A)+")damege...");
            
        } catch (IOException ex) {Logger.getLogger(RandomDuplex.class.getName()).log(Level.SEVERE, null, ex);}
        
        return arm;
        
    }
    
}
