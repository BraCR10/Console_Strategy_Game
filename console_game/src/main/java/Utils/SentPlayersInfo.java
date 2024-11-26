package Utils;

import Main.ClientHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class SentPlayersInfo implements Serializable{
    
    public String ID = "";
    
    public int Win_Counter = 0;
    public int Lose_Counter = 0;
    public int Attacks_Counter = 0;
    public int Succes_Counter = 0;
    public int Failed_Counter = 0;
    public int GaveUp_Counter = 0;
    
    public String Score = "";
    public double Score_NUM = 0;

    public SentPlayersInfo(ClientHandler player) {
        this.ID = player.ID;
        
        this.Win_Counter = player.Win_Counter;
        this.Lose_Counter = player.Lose_Counter;
        this.Attacks_Counter = player.Attacks_Counter;
        this.Succes_Counter = player.Succes_Counter;
        this.Failed_Counter = player.Failed_Counter;
        this.GaveUp_Counter = player.GaveUp_Counter;
        
        this.Score = getScore();
  
    }
    
    private String getScore() {
        if (Failed_Counter == 0) {
            this.Score_NUM = Succes_Counter; 
        } else {
            this.Score_NUM = (double) Succes_Counter / Failed_Counter;
        }
        return "[" + this.Succes_Counter + "/" + this.Failed_Counter + "]";
    }

    public static SentPlayersInfo[] getList(ArrayList<ClientHandler> clients) {
        SentPlayersInfo[] list = new SentPlayersInfo[clients.size()];

  
        for (int i = 0; i < clients.size(); i++) {
            list[i] = new SentPlayersInfo(clients.get(i));
        }

        java.util.Arrays.sort(list, Comparator.comparingDouble((SentPlayersInfo info) -> info.Score_NUM).reversed());

        return list;
    }
}
