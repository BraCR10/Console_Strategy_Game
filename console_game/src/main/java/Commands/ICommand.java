package Commands;

import Player.Controller.ClientController;

public interface ICommand {
    void execute(String[] arg, ClientController client);
}
