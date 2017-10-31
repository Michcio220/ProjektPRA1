package Cominute;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.time.LocalDateTime;
import java.util.Date;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
public class coMinute {


    public coMinute() {
    }

    public void execute() {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.start();

            LocalDateTime now = LocalDateTime.now();
            Date datarozp = new Date(now.getYear(),now.getMonthValue(),now.getDayOfMonth(),8,15,0);
            Date datazakon = new Date(now.getYear(),now.getMonthValue(),now.getDayOfMonth(),18,45,0);

            JobDetail job = newJob(TimeJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            CronTrigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                   //.startAt(datarozp)
                    .withSchedule(cronSchedule("0 0/1 * ? * MON-FRI"))
                    //.endAt(datazakon)
                    .build();

            scheduler.scheduleJob(job, trigger);

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

}