package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SetID implements ICommand{
    public static final String COMMAN_NAME = "setid";

    @Override
    public void execute(String[] arg, ClientController client) {
    
        try {
            if (client.playerData.in.readBoolean()){
                
                client.playerData.playerID = arg[1];
                client.SetuserConsolePrompt(client.playerData.playerID);
                client.writeConsoleln("[COMMAND] : SetID has been executed...");
 
            } else {
                client.writeConsoleln("[ERROR] : Error ID already taken....");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(SetID.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-'NewID'";
    }
}
