package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewGame implements ICommand{
    public static final String COMMAN_NAME = "ng+";

    @Override
    public void execute(String[] arg, ClientController client) {
        
        
         try {
            if (client.playerData.in.readBoolean()){
                client.writeConsoleln("[COMMAND] : YOU started a new game");

            } else {
                client.writeConsoleln("[ERROR] : YOU CANT start a new game");

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
