package Warriors;

import Affinities.Affinities;
import Affinities.Affinity;
import Armaments.ArmFactory;
import Armaments.Armaments;
import Utils.Tools;
import java.io.Serializable;
import java.util.ArrayList;


public class Warrior implements Serializable {
    
    public int HP;
    String name;
    public Affinities affinitiy;
    ArrayList<Armaments> weapons;

    public static String[] names = {
        "Armityle",
        "Darklord",
        "Exodia",
        "Hammer",
        "Hunter",
        "Jinzo",
        "Magician",
        "Malefic",
        "Neptune",
        "Pandemonium",
        "Rose",
        "Sage",
        "Shark",
        "Skull",
        "Warlock",
        "Whitedragon",
        "Wizard"
    };
    
    public String getName(){
        if (this == null){return "back";}
        return this.name;   
    }
    
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
    
    
        
    public Warrior(String arg)  {
        this.HP = 100;
        this.name = arg;
        
        this.affinitiy = Tools.getRandomEnum(Affinities.class);
        
        weapons = new ArrayList<>();
        
        weapons.add(ArmFactory.ArmFactory("w1"));
        weapons.add(ArmFactory.ArmFactory("w2"));
        weapons.add(ArmFactory.ArmFactory("w3"));
        weapons.add(ArmFactory.ArmFactory("w4"));
    }
    
    public int ReceiveDmg(Armaments arm){
        int damage = arm.getDamage(this.affinitiy);
        
        if (damage <= this.HP){this.HP = this.HP - damage;}
        else {this.HP = 0;}
        return damage;

    }
    
    public int getDamage(int index, Affinities Aff){
        return weapons.get(index).getDamage(Aff);
    }

    public String getWeaponsName(int index){
        return weapons.get(index).getName();
    }
    
    public String getAffinity(){
        return Affinity.getString(this.affinitiy);
    
    }
    
    public static String getListWarriors(){
        return String.join(" - ", names);
    }
        
    public boolean WeaponsLeft(){
        boolean statement = false;
        
        for (Armaments arm : weapons){
            statement = statement || arm.CanBeUsed;
        
        }
        
        return statement;
    }
    
    public void RechargeArm(){
        for (Armaments arm : weapons){
            arm.CanBeUsed = true;
        }
    }

    public Armaments getArm(String NAME){
        for (Armaments arm : weapons){
            if(arm.getName().toLowerCase().equals(NAME.toLowerCase())){
                return arm;
            }
        }
        return null;
    } 
   
}
