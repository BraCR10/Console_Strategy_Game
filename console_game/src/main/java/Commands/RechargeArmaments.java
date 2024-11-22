package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RechargeArmaments implements ICommand{
    public static final String COMMAN_NAME = "ra";
    
    
    @Override
    public void execute(String[] arg, ClientController client) {
        try {
            
            boolean MyTurn = client.playerData.in.readBoolean();
            if(MyTurn){
                client.playerData.RA();
                client.writeConsoleln("YOU've recharged ALL your weapons...");}
            
            else {client.writeConsoleln("[ERROR] : Cant recharge your weapons...");}
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(Attack.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @Override
    public String getSyntax() {
        return COMMAN_NAME;
    }    
}
