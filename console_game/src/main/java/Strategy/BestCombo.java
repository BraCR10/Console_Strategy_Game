package Strategy;

import Affinities.Affinities;
import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BestCombo implements Strategy {

    @Override
    public Armaments doStrategy(String[] Args, GameServer server, ClientHandler player) {
        
        Armaments BaseWeapon = player.getArmament(Args[2], Args[3]);
        if (BaseWeapon != null){BaseWeapon.CanBeUsed = false;}
        
        Armaments arm = new Armaments(BaseWeapon);
       
        for (Warrior warrior : player.warriors){
            
            for(int index = 0; index < 4; index++){
            
                for (Affinities aff : Affinities.values()){

                    int newVal = warrior.getDamage(index, aff);

                    if(newVal > arm.getDamage(aff)){
                        arm.getAffinity().replace(aff, newVal);
                    }            
                }
            }
        }
        
        player.timer.startTimer();
        
        try {player.PLAYERoutINFO.writeUTF("Strategy [BestCombo] : "+arm.getHashMapStr());
            
        } catch (IOException ex) {Logger.getLogger(RandomDuplex.class.getName()).log(Level.SEVERE, null, ex);}
        
        return arm;
        
    }
    
}