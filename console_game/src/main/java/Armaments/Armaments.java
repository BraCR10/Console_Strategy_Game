package Armaments;

import java.util.HashMap;
import Affinities.Affinities;
import java.io.Serializable;
import java.util.Random;

public abstract class Armaments implements Serializable{
    
    private String name;
    private boolean CanBeUsed;
        
    private HashMap<Affinities, Integer> Affinity = new HashMap<>();

    private final int min = 20;
    private final int max = 100;
    
    public Armaments(String name) {
        this.name = name;
        this.CanBeUsed = true;
        SetRandomDamage();
        
    }

    public int getDamage(Affinities Affinity){
        return this.Affinity.get(Affinity);
    }
    
    private void SetRandomDamage(){      
        Random random = new Random();
        int randomNum;
                
        for (Affinities element : Affinities.values()){
           randomNum = random.nextInt(max + min) + min;
           Affinity.put(element, randomNum);
        }
    }
    
    
    
}
