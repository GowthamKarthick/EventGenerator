import java.util.Timer;
import java.util.TimerTask;

class ThreadTimer extends TimerTask{
    @Override
    public void run() {
        Events e=Events.getInstance();
        System.out.println("Our process reached 1 Second");
        System.out.print("Created events : ");
        e.print();
        System.exit(0);
   }
}