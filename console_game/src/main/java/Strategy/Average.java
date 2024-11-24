/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        
        try {player.PLAYERoutINFO.writeUTF("Strategy [Average] : "+number+" damage");
            
        } catch (IOException ex) {Logger.getLogger(RandomDuplex.class.getName()).log(Level.SEVERE, null, ex);}
        
        return arm;
        
    }
    
}