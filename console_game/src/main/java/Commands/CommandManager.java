/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.util.HashMap;

public class CommandManager {    
    //hash de ICommands: name, command
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS = new HashMap<>();       
    
    public CommandManager() {           
       //registCommand(EchoCommand.COMMAN_NAME, EchoCommand.class);           
        
    }       
    /*
    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toUpperCase())) {               
            try {   
                  
                return COMMANDS.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {   
                e.printStackTrace();  
                //retorna comando de error en la exception
                //return new ErrorCommand();  
                return null; 
            }           
        } 
        else {
            // retorno de error comando no encontrado
            //return new NotFoundCommand();   
            return null;   
        }   
    }*/

    // to add a command
    public void registCommand(String commandName, Class<? extends ICommand> command) {   
        COMMANDS.put(commandName.toUpperCase(), command);   
    }   
}

