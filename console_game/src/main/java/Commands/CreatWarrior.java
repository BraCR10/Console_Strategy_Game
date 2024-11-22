package Commands;

import Controller.ClientController;
import Warriors.Warrior;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatWarrior implements ICommand{
    public static final String COMMAN_NAME = "crtw";

    @Override
    public void execute(String[] arg, ClientController client) {
        try {
            if (client.playerData.in.readBoolean()){
                
            Warrior warrior = (Warrior) client.playerData.inObj.readObject();
            client.playerData.warriors.add(warrior);
            client.setCards();
            client.writeConsoleln("[COMMAND] : CreatWarrior has been executed...");}
            
            else {
                client.writeConsoleln("[ERROR] : Error Parameters/Arguments are invalid....");

            }
                        
        } catch (IOException ex) {
            Logger.getLogger(CreatWarrior.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreatWarrior.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-'WarriorsName'-'Type'-'Weapon01'-'Weapon02'-'Weapon03'-'Weapon04'";
    }
}
