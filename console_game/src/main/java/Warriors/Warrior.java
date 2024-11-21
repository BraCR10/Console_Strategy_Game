package Warriors;

import Affinities.Affinities;
import Affinities.Affinity;
import Armaments.ArmFactory;
import Armaments.Armaments;
import java.io.Serializable;
import java.util.ArrayList;


public class Warrior implements Serializable {
    
    int HP;
    String name;
    Affinities affinitiy;
    ArrayList<Armaments> weapons;

    public Warrior(String[] arg)  {
        this.HP = 100;
        this.name = arg[1];
        
        this.affinitiy = Affinity.getAffinity(arg[2]);
        
        weapons = new ArrayList<>();
        
        weapons.add(ArmFactory.ArmFactory(arg[3]));
        weapons.add(ArmFactory.ArmFactory(arg[4]));
        weapons.add(ArmFactory.ArmFactory(arg[5]));
        weapons.add(ArmFactory.ArmFactory(arg[6]));
    }   
}
