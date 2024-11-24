
package Utils;

import Affinities.Affinity;
import Main.ClientHandler;
import Main.GameServer;
import Warriors.Warrior;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tools {
    
    private String[] names = null; 
    private ArrayList<String> shuffledNames;
    private int currentIndex; 
    
    public Tools(String[] names) {
        this.names = names.clone();
        reshuffle();
    }
    
    private void reshuffle() {
        shuffledNames = new ArrayList<>();
        Collections.addAll(shuffledNames, names); 
        Collections.shuffle(shuffledNames);
        currentIndex = 0;
    }
    public String getNextName() {
        if (currentIndex >= shuffledNames.size()) {
            reshuffle();
        }
        return shuffledNames.get(currentIndex++);
    }
    public boolean hasMoreNames() {
        return currentIndex < shuffledNames.size();
    }
    public void reset() {
        reshuffle();
    }
    
    public static boolean Check_SetID(GameServer server, ClientHandler client, String[] args){
        
        if(args.length < 2){return false;}
        
        for (ClientHandler c : server.players){
            if(c.ID.equals(args[1])){return false;}
        }
        
        return !("".equals(args[1]) || args[1] == null);
    }
    
    public static boolean Check_SelW(GameServer server, ClientHandler client, String[] args){
        
        if(args.length < 2){return false;}
        
        int c = 0;
        for(Warrior w : client.warriors){
            if (c>= 4){break;}
            if (args[1].toLowerCase().equals(w.getName().toLowerCase())){
                return true;          
            }
            c++;
        }
        
        return false;
    }

    public static boolean Check_CrtW(GameServer server, ClientHandler client, String[] args){
        boolean NameFound = false;
        
        if (args.length < 7){return false;}
        
        for (String str : Warrior.names){
            if (str.toLowerCase().equals(args[1].toLowerCase())){
                NameFound = true;
                break;
            }
        }
        
        if(!NameFound){return false;}
        
        return Affinity.getAffinity(args[2]) != null;
    }    

    public static boolean Check_CRB(GameServer server, ClientHandler client, String[] args){
        if (args.length < 2){return false;}
        int num;
            try {
               num = Integer.parseInt(args[1]);
               return true;
            }
            catch (NumberFormatException e) {
               return false;
            }
    }   
    
    public static boolean Check_IsMyTurn(GameServer server, ClientHandler client, String[] args){
        return client.IsMyTurn;    
    }
    
    public static boolean Check_ReceiverExists(GameServer server, ClientHandler client, String[] args){
        ClientHandler rec = server.getClient(args[1]);
        return rec != null;
    
    }
    
    public static boolean Check_CanUseStr(GameServer server, ClientHandler client, String[] args){
        
        if (args.length < 5) {return false;}
        return "none".equals(args[4].toLowerCase()) || !client.timer.isAlive();
    }
    
    public static boolean Check_CanUseWarrior(GameServer server, ClientHandler client, String[] args){

        int c = 0;
        
        for(Warrior w : client.warriors){
            if (c>= 4){break;}
            
            System.out.println("1 c:"+args[2].toLowerCase().equals(w.getName().toLowerCase()));
            System.out.println("2 c:"+(w.HP > 0));
            
            if (args[2].toLowerCase().equals(w.getName().toLowerCase()) && w.HP > 0){
                
                return true;          
            }
            c++;
        }
        
        return false;
    
    }

    public static boolean Check_CanUseWeapons(GameServer server, ClientHandler client, String[] args){

        if(client.getArmament(args[2], args[3]) ==  null){return false;}
        
        
        int c = 0;
        for(Warrior w : client.warriors){
            
            if (args[2].toLowerCase().equals(w.getName().toLowerCase()) && w.HP > 0 && w.getArm(args[3]) != null){
                return w.getArm(args[3]).CanBeUsed;          
            }
            
            c++;
        }
               
        return false;
    
    }

    
    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        T[] enumConstants = enumClass.getEnumConstants();
        int randomIndex = new Random().nextInt(enumConstants.length);
        return enumConstants[randomIndex];
    }
}
