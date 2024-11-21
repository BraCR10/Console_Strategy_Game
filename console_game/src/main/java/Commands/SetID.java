package Commands;

import Player.Controller.ClientController;


public class SetID implements ICommand{
    public static final String COMMAN_NAME = "setid";

    @Override
    public void execute(String[] arg, ClientController client) {
        System.out.println("[COMMAND] : SetID has been executed...");
        client.playerData.playerID = arg[1];
        client.SetuserConsolePrompt(client.playerData.playerID); 
    }
    
}
