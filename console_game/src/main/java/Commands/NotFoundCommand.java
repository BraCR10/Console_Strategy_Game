package Commands;

import Controller.ClientController;


public class NotFoundCommand implements ICommand {

    @Override
    public void execute(String[] arg, ClientController client) {
        client.writeConsoleln("[ERROR] : NotFoundCommand...");
    }

    @Override
    public String getSyntax() {
        return "NotFoundCommand";
    }
}
