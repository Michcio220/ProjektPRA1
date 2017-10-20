package Timer;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeJob implements Job {

    public TimeJob() {
    }



    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        if(sdf = "08:15:00"){
            System.out.println( sdf.format(cal.getTime()) );
        }

    }
}
