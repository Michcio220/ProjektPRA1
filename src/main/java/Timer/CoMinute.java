package Timer;

import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CoMinute{

    public static void main(String [] arg){
        Timer timer = new Timer();

        TimerTask timer_task = new TimerTask() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                System.out.println(sdf.format(calendar.getTime()));

            }
        };
        timer.schedule(timer_task,0,60000);
    }

}
