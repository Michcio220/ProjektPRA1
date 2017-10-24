package ZapiszDoPliku;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.File;


public class Zapisz implements org.quartz.Job {

    public Zapisz(){
    }


    public void execute(JobExecutionContext context) throws JobExecutionException{
        File plikOdpowiedzi = new File("");

    }



}
