
package Strategy;

import Affinities.Affinities;
import Affinities.Affinity;
import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;
import Utils.Tools;
import Warriors.Warrior;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomComb implements Strategy {
    private String ToStr = "";

    @Override
    public String getToStr() {
        return ToStr;
    }
    @Override
    public Armaments doStrategy(String[] Args, GameServer server, ClientHandler player) {
        
        Armaments BaseWeapon = player.getArmament(Args[2], Args[3]);
        if (BaseWeapon != null){BaseWeapon.CanBeUsed = false;}
        
        Armaments arm = new Armaments(BaseWeapon);
        
        
        Random rand = new Random();
        int randomIndex;
        
        for (Warrior warrior : player.warriors){
            
            randomIndex = rand.nextInt(4);
            
            for (Affinities aff : Affinities.values()){
                
                int newVal = warrior.getDamage(randomIndex, aff);
                
                if(newVal > arm.getDamage(aff)){
                    arm.getAffinity().replace(aff, newVal);
                }            
            }
        }
        
        player.timer.startTimer();
        
        this.ToStr = "Strategy [RandomComb] : "+arm.getHashMapStr();
        try {player.PLAYERoutINFO.writeUTF(this.ToStr);
            
        } catch (IOException ex) {Logger.getLogger(RandomDuplex.class.getName()).log(Level.SEVERE, null, ex);}
        
        return arm;
        
    }
    
}
