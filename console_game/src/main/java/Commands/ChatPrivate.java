package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatPrivate implements ICommand{
    public static final String COMMAN_NAME = "cpr";

    @Override
    public void execute(String[] arg, ClientController client) {
        
        try {
            if (client.playerData.in.readBoolean()){             
                client.writeConsoleln("[COMMAND] : ChatPrivate has been executed...");
 
            } else {
                client.writeConsoleln("[ERROR] : Error Receivers ID inexistent....");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(SetID.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public String getSyntax() {
        return COMMAN_NAME+"'Receiver'-Msg";
    }
}
