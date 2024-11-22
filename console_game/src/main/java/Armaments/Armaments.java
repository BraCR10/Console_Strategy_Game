package Armaments;

import java.util.HashMap;
import Affinities.Affinities;
import java.io.Serializable;
import java.util.Random;

public class Armaments implements Serializable{
    
    private String name;
    public boolean CanBeUsed;
        
    private HashMap<Affinities, Integer> affinity = new HashMap<>();

    private final int min = 20;
    private final int max = 100;
    
    public Armaments(String name) {
        this.name = name;
        this.CanBeUsed = true;
        SetRandomDamage();
        
    }

    private void SetRandomDamage(){      
        Random random = new Random();
        int randomNum;
                
        for (Affinities element : Affinities.values()){
           randomNum = random.nextInt(max + min) + min;
           affinity.put(element, randomNum);
        }
    }

    
    
    public String getName() {
        return name;
    }

    public int getDamage(Affinities Affinity){
        return this.affinity.get(Affinity);
    }    
    
    public HashMap<Affinities, Integer> getAffinity() {
        return affinity;
    }
    
    
}
