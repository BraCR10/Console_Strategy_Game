package Threads;


public class StrategyTimer {
    private final int totalTime = 180;
    private Thread timerThread;
    private int timeRemaining;
    
    public void startTimer() {
        if (timerThread != null && timerThread.isAlive()) {
            throw new IllegalStateException("Timer is already running!");
        }

        timerThread = new Thread(() -> {
            for (timeRemaining = totalTime; timeRemaining > 0; timeRemaining--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println("Timer interrupted.");
                    return; 
                }
            }
        });

        timerThread.start();
    }

    public boolean isAlive() {
        return timerThread != null && timerThread.isAlive();
    }
    
    public String getTimeRemaining(){
            return this.timeRemaining+"s";
    
    }

}
