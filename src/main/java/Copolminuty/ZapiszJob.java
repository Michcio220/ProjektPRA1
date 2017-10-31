package Copolminuty;


import org.quartz.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ZapiszJob implements Job {

    public static String ARRAY = "array";

    public ZapiszJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        try {

        PrintWriter writer = new PrintWriter(new FileOutputStream(
                new File("Odpowiedz/odp.txt"),
        false)); //Plik w którym zapisywane sa w tym pliku

        JobKey key = context.getJobDetail().getKey();

        JobDataMap datamap = context.getJobDetail().getJobDataMap();

        ArrayList<SqlAns> array =(ArrayList<SqlAns>)datamap.get(ARRAY); //ArrayList obiektów z numeremi zadań
                                                                        // i poleceniami
        for(SqlAns counter: array){
            writer.println(counter.getNumber() +"\n" + counter.getCiagPolecen());//wypisywanie numeru zadanie i
                                                                                 //tresci polecenia
        }
        writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





    }
}
