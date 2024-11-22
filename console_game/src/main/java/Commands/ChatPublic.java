

package Commands;

import Controller.ClientController;


public class ChatPublic implements ICommand {
    public static final String COMMAN_NAME = "cht";

    @Override
    public void execute(String[] arg, ClientController client) {
        client.writeConsoleln("[COMMAND] : ChatPublic has been executed...");
    }

    @Override
    public String getSyntax() {
        return COMMAN_NAME+"-Msg";
    }
    
}
