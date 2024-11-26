package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Peace implements ICommand{
    public static final String COMMAN_NAME = "peace";

    @Override
    public void execute(String[] arg, ClientController client) {

        try {
            if (client.playerData.in.readBoolean()){
                client.writeConsoleln("[COMMAND] : YOU ASKED FOR PEACE....");

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