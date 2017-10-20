package Timer;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class CoMinute {

    public static void main(String[] arg) throws SchedulerException {

        try {

            Scheduler mySchedule = StdSchedulerFactory.getDefaultScheduler();

            mySchedule.start();

            JobDetail MyJob

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
