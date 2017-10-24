package ZapiszDoPliku;

import org.quartz.JobDetail;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import static org.quartz.JobBuilder.*;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.*;

public class MainZapisz {

    public static void main(String [] args) throws SchedulerException {

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        Time time = new Time(8,15,0);
        Time time2 = new Time(9,45,0);
        Date date = new Date();
        Date date2 = new Date();
        date.setTime(time.getTime());
        date2.setTime(time2.getTime());


        JobDetail job =  newJob(Zapisz.class)
                .withIdentity("MyJob","group1")
                .build();

        SimpleTrigger triger = newTrigger()
        .withIdentity("trigger1","group1")
        .startAt(date)
        .withSchedule(simpleSchedule()
                .withIntervalInMinutes(1)
                .withRepeatCount(90))
        .build();

        sched.scheduleJob(job,triger);




    }

}
