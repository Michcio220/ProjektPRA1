package Testy;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.File;

public class MyJob implements org.quartz.Job {

    public MyJob() {
    }

    public void execute (JobExecutionContext context) throws JobExecutionException{
        System.err.println("Hello World! My job is executing. ");
        File plidOdpowiedzi;
        plidOdpowiedzi = new File("C:/Users/admin/Desktop/Projekt na Zajecia/ProjektPRA1/src/main/java/Odpowiedz/odp.txt");
    }
}
