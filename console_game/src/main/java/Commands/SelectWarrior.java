package Commands;

import Controller.ClientController;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectWarrior implements ICommand{
    public static final String COMMAN_NAME = "selw";

    @Override
    public void execute(String[] arg, ClientController client) {
        try {
            if (client.playerData.in.readBoolean()){
                
                Warrior data = client.getWarrior(arg[1]);
                
                client.playerScreen.setTableCardStats(data);
                client.playerScreen.setCardPomptTextField(data);
                
                
                client.writeConsoleln("[COMMAND] : SelectWarrior has been executed...");
 
            } else {
                client.writeConsoleln("[ERROR] : Warrior NOT found....");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(SetID.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-'WarriorsName'";
    }

}
