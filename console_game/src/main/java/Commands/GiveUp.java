
package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class GiveUp implements ICommand{
    public static final String COMMAN_NAME = "give up";

    @Override
    public void execute(String[] arg, ClientController client) {
        
        
         try {
            if (client.playerData.in.readBoolean()){
                client.writeConsoleln("[COMMAND] : YOU GAVE UP (YOU'VE LOST)...");

            } else {
                client.writeConsoleln("[ERROR] : You ARE NOT play this game, anymore....");

            }
        } catch (IOException ex) {
            Logger.getLogger(SetID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getSyntax() {
        return COMMAN_NAME;
    }
}