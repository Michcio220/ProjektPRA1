package ZapiszDoPliku;

import org.quartz.JobDetail;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.sql.Time;
import java.util.Date;

import static org.quartz.JobBuilder.*;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.*;

public class MainZapisz {

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