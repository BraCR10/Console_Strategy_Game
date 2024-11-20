package Armaments;

public class ArmFactory {
    
    public Armaments ArmFactory(String str){
        if (str == null) {
            return null;
        }
        return switch (str.toLowerCase()) {
            case "axe" -> new Axe();
            case "bow" -> new Bow();
            case "gun" -> new Gun();
            case "shield" -> new Shield();
            case "spear" -> new Spear();
            case "spell" -> new Spell();
            case "sword" -> new Sword();
            default -> null;
        };
    }
    
}
