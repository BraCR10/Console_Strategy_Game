
package Affinities;

public class Affinity {

    public static Affinities getAffinity(String arg){
        switch (arg.toLowerCase()) {
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
            default -> {
                System.out.println("[ERROR] : ELEMENT ("+arg+") Not found (Affinity.java --> getAffinity(String))");
                return null;
            }
        }
    
    }
    
}
