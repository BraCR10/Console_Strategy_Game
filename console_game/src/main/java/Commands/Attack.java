package Commands;

import Controller.ClientController;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Attack implements ICommand{
    public static final String COMMAN_NAME = "atk";
    
    
    @Override
    public void execute(String[] arg, ClientController client) {
        try {

            
            if(client.playerData.in.readBoolean()){
                
                client.writeConsoleln("[YOU ATTACKED --> "+arg[1]+"] ");
                int totalDamage = client.playerData.in.readInt();//receiving confirmation of server
                client.displayDataNewAttak(arg[1], arg[2], arg[3],totalDamage);
                //receiving own stats
                int wins = client.playerData.in.readInt();
                int losses = client.playerData.in.readInt();
                int kills = client.playerData.in.readInt();
                int success = client.playerData.in.readInt();
                int failed = client.playerData.in.readInt();
                int giveup = client.playerData.in.readInt();
                client.displayStats(wins,losses,kills,success,failed,giveup);
                //receiving opponet stats
                int winsOp = client.playerData.in.readInt();
                int lossesOp = client.playerData.in.readInt();
                int killsOp = client.playerData.in.readInt();
                int successOp = client.playerData.in.readInt();
                int failedOp = client.playerData.in.readInt();
                int giveupOp = client.playerData.in.readInt();
                String nameOp = client.playerData.in.readUTF();
                client.displayStatsOp(winsOp,lossesOp,killsOp,successOp,failedOp,giveupOp,nameOp);

            }else {
                client.writeConsoleln(client.playerData.in.readUTF());}
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(Attack.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
        
        
    }

    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-'Opponent'-'Warrior'-'Weapon'-'Strategy'";
    }

    
}
