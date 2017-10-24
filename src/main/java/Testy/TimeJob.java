package Testy;




import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeJob implements Job {

    public TimeJob() {
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        LocalDateTime[] array;
        array = new LocalDateTime[17];
        LocalDateTime now = LocalDateTime.now();

        for(int i =0; i<17; i++){
            if(i == 0) {

                array[i] = LocalDateTime.of(now.getYear(),now.getMonth(),now.getDayOfMonth(),8,15,0);

            } else if(i % 2 == 0){

                array[i] = array[i-1].plusMinutes(90);

            }else if(i % 2 != 0){

                array[i] = array[i-1].plusMinutes(15);

            }
        }

        for(int i=0; i<17; i++){
            if(now.isAfter(array[0]) && now.isBefore(array[16])) {
                if (now.isAfter(array[i]) && i % 2 != 0 && now.isBefore(array[i + 1])) {
                    Long diffrence = now.until(array[i + 1], ChronoUnit.MINUTES);
                    System.err.println("Do konca zajęć zostalo: " + diffrence.toString() + " min");
                    break;
                } else if (now.isAfter(array[i]) && i % 2 == 0 && now.isBefore(array[i + 1])) {
                    Long diffrence = now.until(array[i + 1], ChronoUnit.MINUTES);
                    System.err.println("Do konca przerwy zostalo: " + diffrence.toString() + " min");
                    break;
                }
            }
        }

    }
}
