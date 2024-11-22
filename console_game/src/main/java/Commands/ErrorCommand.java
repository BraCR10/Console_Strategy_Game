
package Commands;

import Controller.ClientController;

public class ErrorCommand implements ICommand {

    @Override
    public void execute(String[] arg, ClientController client) {
        client.writeConsoleln("[ERROR] : error parameters/ arguments are invalid....");
    }

    @Override
    public String getSyntax() {
        return "ErrorCommand";
    }
    
}
