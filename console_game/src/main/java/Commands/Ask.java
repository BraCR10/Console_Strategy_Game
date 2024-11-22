package Commands;

import Controller.ClientController;
import Warriors.Warrior;


public class Ask implements ICommand{
    public static final String COMMAN_NAME = "ask";

    @Override
    public void execute(String[] arg, ClientController client) {
        
        switch (arg[1].toLowerCase()) {
            case "sntx" -> {
                client.writeConsoleln(CommandManager.getCommandsSyntax(arg[2]));
                
            }
            case "warlist" -> {
                client.writeConsoleln(Warrior.getListWarriors());
            
            }
            
            case "types" -> {
                client.writeConsoleln(Affinities.Affinity.getList());
            
            }

        }
        
    }
    
    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-'arg01'-'arg02'";
    }
   
}
