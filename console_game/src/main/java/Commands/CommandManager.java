package Commands;

import java.util.HashMap;

public class CommandManager {    
    private static final HashMap<String, ICommand> COMMANDS = new HashMap<>();       
    
    public CommandManager() {        
        
       registCommand(Ask.COMMAN_NAME, new Ask());
       registCommand(Attack.COMMAN_NAME, new Attack()); 
       
       registCommand(ChatPrivate.COMMAN_NAME, new ChatPrivate());
       registCommand(ChatPublic.COMMAN_NAME, new ChatPublic());
       registCommand(Help.COMMAN_NAME, new Help(COMMANDS));
       registCommand(CreatRandomBeasts.COMMAN_NAME, new CreatRandomBeasts());
       
       registCommand(SelectPlayer.COMMAN_NAME, new SelectPlayer());
       
       registCommand(CreatWarrior.COMMAN_NAME, new CreatWarrior());
       registCommand(PassTurn.COMMAN_NAME, new PassTurn());
       registCommand(RechargeArmaments.COMMAN_NAME, new RechargeArmaments());
       registCommand(SelectWarrior.COMMAN_NAME, new SelectWarrior());
       registCommand(SetID.COMMAN_NAME, new SetID());
    }       

    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toLowerCase())) { 
            try {return COMMANDS.get(commandName.toLowerCase());} 
            catch (Exception e) {e.printStackTrace();return new ErrorCommand();  
            }           
        } else {
            return new NotFoundCommand();
        }   
    }

    public static void registCommand(String commandName, ICommand command) {   
        COMMANDS.put(commandName.toLowerCase(), command);  
        
    }   
    
    public static String getCommandsSyntax(String arg){
        String str = "";
        
        for (String key : COMMANDS.keySet()){
            if (key.toLowerCase().equals(arg.toLowerCase())){
            str = "["+key+"] : "+COMMANDS.get(key.toLowerCase()).getSyntax();}
        }
       
        return str;
    }
}

