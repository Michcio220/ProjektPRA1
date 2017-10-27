package ZapiszDoPliku;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.junit.Assert.*;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class MainZapiszTest {
    @Test
    public static void main(String[] args) throws SchedulerException {

        try {

            Scheduler sf = StdSchedulerFactory.getDefaultScheduler();

            sf.start();

            JobDetail job = newJob(MyJob.class)
                    .withIdentity("MyJob", "group1")
                    .build();

            SimpleTrigger triger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(30)
                            .repeatForever())
                    .build();

            sf.scheduleJob(job, triger);

        } catch (SchedulerException se) {
            se.printStackTrace();
        }


    }
}