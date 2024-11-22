package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassTurn implements ICommand{
    public static final String COMMAN_NAME = "pass";

    @Override
    public void execute(String[] arg, ClientController client) {
        try {

            boolean MyTurn = client.playerData.in.readBoolean();            
            if(MyTurn){client.writeConsoleln("[COMMAND] : YOU PASSED your turn...");}
            else {client.writeConsoleln("[ERROR] : IS NOT your turn you can not PASS...");}

        } catch (IOException ex) {
            Logger.getLogger(PassTurn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getSyntax() {
        return COMMAN_NAME;
    }
    
}
