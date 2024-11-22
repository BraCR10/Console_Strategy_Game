package Armaments;

public class ArmFactory {
    
    public static Armaments ArmFactory(String str){
        if (str == null) {return null;}
        return(new Armaments(str.toUpperCase()));
    }
    
}
