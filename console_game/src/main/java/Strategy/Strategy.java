package Strategy;

import Armaments.Armaments;
import Main.ClientHandler;
import Main.GameServer;

public interface Strategy {
    public Armaments doStrategy(String[] Args, GameServer server, ClientHandler player);
    public String getToStr();
}
