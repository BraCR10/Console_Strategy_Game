package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StrategyTimer {
    
    private final int totalTime = 180;
    private final Thread Timer;

    public StrategyTimer() {
        
        this.Timer = new Thread(() -> {
            
            for (int timeRemaining = totalTime; timeRemaining >= 0; timeRemaining--) {
                try { Thread.sleep(1000);} 
                catch (InterruptedException ex) {
                Logger.getLogger(StrategyTimer.class.getName()).log(Level.SEVERE, null, ex);}
            }
        });
    }

    public void StartTimer(){
        Timer.start();
    }
    
    public boolean isAlive(){
        return Timer.isAlive();
    }
       
}
