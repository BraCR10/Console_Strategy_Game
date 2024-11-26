package Commands;

import Controller.ClientController;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ask implements ICommand{
    public static final String COMMAN_NAME = "ask";

    @Override
    public void execute(String[] arg, ClientController client) {
        
        switch (arg[1].toLowerCase()) {
            case "sntx" -> {
                client.writeConsoleln(CommandManager.getCommandsSyntax(arg[2]));
                
            }
            case "warlist" -> {
                client.writeConsoleln(Warrior.getListWarriors());
            
            }
            
            case "types" -> {
                client.writeConsoleln(Affinities.Affinity.getList());
            
            }
            
            case "players" -> {
                
            try {
                client.writeConsoleln("Players : "+client.playerData.in.readUTF());
            
            } catch (IOException ex) {
                Logger.getLogger(Ask.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
            
            case "str" -> {
                
            try {
                client.writeConsoleln("Timer : "+client.playerData.in.readUTF());
            
            
            } catch (IOException ex) {
                Logger.getLogger(Ask.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
            
            case "myturn" -> {
                
            try {
                client.writeConsoleln("My Turn : ["+client.playerData.in.readBoolean()+"]");
            
            
            } catch (IOException ex) {
                Logger.getLogger(Ask.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
            
        }
        
    }
    
    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-'arg01'-'arg02'";
    }
   
}
