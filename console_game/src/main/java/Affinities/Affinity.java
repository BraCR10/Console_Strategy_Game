package Affinities;

public class Affinity {

    public static Affinities getAffinity(String arg){
        switch (arg.toLowerCase()) {
            //----------------------------------------
            case "a" -> {return Affinities.Air;}
            case "d" -> {return Affinities.Dark;}
            case "e" -> {return Affinities.Earth;}
            case "w" -> {return Affinities.Water;}
            case "f" -> {return Affinities.Fire;}
            case "l" -> {return Affinities.Lightning;}
            case "i" -> {return Affinities.Ice;}
            case "p" -> {return Affinities.Poison;}
            case "h" -> {return Affinities.Holy;}
            case "s" -> {return Affinities.Steel;}
            
            //----------------------------------------
            case "air" -> {return Affinities.Air;}
            case "dark" -> {return Affinities.Dark;}
            case "earth" -> {return Affinities.Earth;}
            case "water" -> {return Affinities.Water;}
            case "fire" -> {return Affinities.Fire;}
            case "lightning" -> {return Affinities.Lightning;}
            case "ice" -> {return Affinities.Ice;}
            case "poison" -> {return Affinities.Poison;}
            case "holy" -> {return Affinities.Holy;}
            case "steel" -> {return Affinities.Steel;}
            
            //----------------------------------------
            default -> {
                System.out.println("[ERROR] : ELEMENT ("+arg+") Not found (Affinity.java --> getAffinity(String))");
                return null;
            }
        }
    
    }
    
    public static String getString(Affinities A){
        switch (A) {
            
            case Affinities.Air -> {return "AIR";}
            case  Affinities.Dark -> {return "DARK";}
            case  Affinities.Earth -> {return "EARTH";}
            case  Affinities.Water -> {return "WATER";}
            case  Affinities.Fire -> {return "FIRE";}
            case  Affinities.Lightning -> {return "LIGHTNING";}
            case  Affinities.Ice -> {return "ICE";}
            case Affinities.Poison -> {return "POISON";}
            case  Affinities.Holy -> {return "HOLY";}
            case  Affinities.Steel -> {return "STEEL";}
            
            default -> {
                System.out.println("[ERROR] : ELEMENT Not found (Affinity.java --> getAffinity(String))");
                return null;
            }
        }
    }

    public static String getList(){
        String list = "";
        
        for (Affinities A : Affinities.values()){
            list += getString(A).toUpperCase()+" - ";
        }
        
        return list;

    }
    
}
