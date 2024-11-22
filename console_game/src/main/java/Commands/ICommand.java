package Commands;

import Controller.ClientController;

public interface ICommand {
    void execute(String[] arg, ClientController client);
    String getSyntax();
}
