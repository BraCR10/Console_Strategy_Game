package Commands;
import Controller.ClientController;
import java.util.HashMap;

public class Help  implements ICommand{
    public static final String COMMAN_NAME = "help";
    private   HashMap<String, ICommand> COMMANDS = new HashMap<>();
    public Help( HashMap<String, ICommand> commands) {
        this.COMMANDS=commands;
    }
    
   
    
    
    @Override
    public void execute(String[] arg, ClientController client) {
        client.writeConsoleln("\n\n Help command:\n");
        
        for (String key : COMMANDS.keySet()){
            client.writeConsoleln("Command: "+key+"   Sintaxis: "+COMMANDS.get(key.toLowerCase()).getSyntax() );
        }
       
    }
    
    @Override
    public String getSyntax() {
        return COMMAN_NAME;
    }
    
}