package Strategy;

import Affinities.Affinities;
import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Average implements Strategy {
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
        int number = 0;
        int counter = 0;
       
        for (Warrior warrior : player.warriors){
            
            for(int index = 0; index < 4; index++){
            
                for (Affinities aff : Affinities.values()){

                    int add = warrior.getDamage(index, aff);
                    number += add;

                    counter++;
                }
            
            counter++;
            }
        
        counter++;
        }
        
        if (counter == 0){counter = 1;}
        
        number = number/counter;
        
        player.timer.startTimer();
        
        for (Affinities aff : Affinities.values()){
            arm.getAffinity().replace(aff, number);
        }
        
        this.ToStr = "Strategy [Average] : "+number+" damage";
        try {player.PLAYERoutINFO.writeUTF(this.ToStr);
            
        } catch (IOException ex) {Logger.getLogger(RandomDuplex.class.getName()).log(Level.SEVERE, null, ex);}
        
        return arm;
        
    }
    
}