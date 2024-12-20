package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Attack implements ICommand{
    public static final String COMMAN_NAME = "atk";
    
    
    @Override
    public void execute(String[] arg, ClientController client) {
        try {

            
            if(client.playerData.in.readBoolean()){
                
                client.writeConsoleln("[YOU ATTACKED --> "+arg[1]+"] ");}

            else {
                client.writeConsoleln(client.playerData.in.readUTF());}
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(Attack.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-'Opponent'-'Warrior'-'Weapon'-'Strategy'";
    }

    
}
