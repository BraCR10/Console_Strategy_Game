package Commands;

import Player.Controller.ClientController;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatWarrior implements ICommand{
    public static final String COMMAN_NAME = "crtw";

    @Override
    public void execute(String[] arg, ClientController client) {
        try {
            System.out.println("[COMMAND] : CreatWarrior has been executed...");
            Warrior warrior = (Warrior) client.playerData.inObj.readObject();
            client.playerData.warriors.add(warrior);

                        
        } catch (IOException ex) {
            Logger.getLogger(CreatWarrior.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreatWarrior.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
