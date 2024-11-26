package Commands;

import Controller.ClientController;
import Utils.SentPlayersInfo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectPlayer implements ICommand {
    public static final String COMMAN_NAME = "sp";

    @Override
    public void execute(String[] arg, ClientController client) {
    
        try {
            if (client.playerData.in.readBoolean()){
                
                SentPlayersInfo data = (SentPlayersInfo) client.playerData.inObj.readObject();
                client.playerScreen.setTableAgainst(data);

                client.writeConsoleln("[COMMAND] : SelectPlayer has been executed...");

                
            } else {
                client.writeConsoleln("[ERROR] : Error ID NOT found....");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(SetID.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelectPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-'PlayersID'";
    }
}