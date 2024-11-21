package Commands;

import java.util.HashMap;

public class CommandManager {    
    private static final HashMap<String, ICommand> COMMANDS = new HashMap<>();       
    
    public CommandManager() {           
       registCommand(SetID.COMMAN_NAME, new SetID());
       registCommand(CreatWarrior.COMMAN_NAME, new CreatWarrior());
    }       
    
    
    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toLowerCase())) { 
 
            try {return COMMANDS.get(commandName.toLowerCase());} 
            
            catch (Exception e) {   
                e.printStackTrace();  
                //retorna comando de error en la exception
                //return new ErrorCommand();  
                return null; 
            }           
        } 
        
        else {return new NotFoundCommand();}   
    }


    public void registCommand(String commandName, ICommand command) {   
        COMMANDS.put(commandName.toLowerCase(), command);  
        
    }   
}

