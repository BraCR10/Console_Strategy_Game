package Commands;

import Player.Controller.ClientController;


public class NotFoundCommand implements ICommand {

    @Override
    public void execute(String[] arg, ClientController client) {
        client.writeConsoleln("[ERROR] : NotFoundCommand...");
    }
    
}
