package Copolminuty;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

public class coPolMinuty {

    public coPolMinuty() {
    }

    public void execute() throws SchedulerException {

        try {
            PrintWriter writer = new PrintWriter("Odpowiedz/odp.txt"); //za kazdym razem powstaje nowy plik

            String wzorzec1 = "SELECT FROM"; //wzorce poleceń sql
            String wzorzec2 = "SELECT FROM WHERE";
            String wzorzec3 = "SELECT FROM WHERE ORDER BY";
            String wzorzec4 = "SELECT FROM ORDER BY";

            ArrayList<SqlAns> lista = new ArrayList<>(); // Lista obiektow z numerem zadania i poleceniem
            Scanner scanner = new Scanner(System.in);

            int numerZadania = 0;
            String polecenie = "";

            System.out.println("By zakonczyc wpisywanie polecen prosze wpisac \n0\nEND"); //

            while (scanner.hasNextLine()){
                numerZadania = Integer.parseInt(scanner.nextLine());
                polecenie = scanner.nextLine();
                if(polecenie.matches(wzorzec1) || polecenie.matches(wzorzec2) || polecenie.matches(wzorzec3) || polecenie.matches(wzorzec4)){ // czy zgadzaja się ze wzorcami
                    lista.add(new SqlAns(numerZadania, polecenie));
                }else if(polecenie.equals("END")){
                    break;
                }else{
                    System.err.println("Błąd!Zła kolejność poleceń");
                }
            }
            Collections.sort(lista); // Sortuje Arraylist na podstawie numeru zadań

            JobDetail job = newJob(ZapiszJob.class)
                    .withIdentity("job2", "group2")
                    .build();

            job.getJobDataMap().put(ZapiszJob.ARRAY, lista);

            CronTrigger Ctrigger = newTrigger()
                    .withIdentity("trigger2","group2")
                    .startNow()
                    .withSchedule(cronSchedule("0/30 * * ? * *")) //co 30sec licząc co pełnej minuty
                    .build();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, Ctrigger);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
