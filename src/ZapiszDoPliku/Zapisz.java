package ZapiszDoPliku;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class Zapisz {

    Timer timer = new Timer();
    TimerTask timer_task = new TimerTask() {
        @Override
        public void run() {
            File file = new File("C:\\Users\\admin\\Desktop\\odp.txt");
        }
    };

    public void setTimer(){
        timer.schedule(timer_task,0,30000);
    }

    public Timer getTimer() {
        return timer;
    }
}
