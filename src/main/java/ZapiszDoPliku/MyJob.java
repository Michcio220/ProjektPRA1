package ZapiszDoPliku;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

@PersistJobDataAfterExecution
public class MyJob implements org.quartz.Job {

    public MyJob() {
    }

    public void execute (JobExecutionContext context) throws JobExecutionException{


        try {
            PrintWriter writer = new PrintWriter("C:/Users/admin/Desktop/Projekt na Zajecia/ProjektPRA1//Odp.txt");


            SqlAns[] tablica = new SqlAns[100];
            Scanner scanner = new Scanner(System.in);
            String zdanie = "";
            zdanie = zdanie + scanner.nextInt() + "\n";

            while(!(zdanie = scanner.nextLine()).isEmpty()) {

                String[] string = zdanie.split("\\s+");

                System.err.println(Arrays.toString(string));

                zdanie = zdanie + scanner.nextLine() + "\n";

            }


            scanner.close();


            SqlAns sqlans = new SqlAns();

            sqlans.setCiagPolecen(zdanie);

            String[] array = new String[4];
            array[1] = "\\d\nSELECT\nFROM\nWHERE";
            array[0] = "\\d\n" + "SELECT\n" + "FROM";

                System.err.println(zdanie);

                if(zdanie.matches(array[0]) || zdanie.matches(array[1])) {

                    writer.append(sqlans.getCiagPolecen());

                    writer.close();
                }
        } catch (FileNotFoundException e) {
            System.err.println("Hello World! My job is not executing. ");
            e.printStackTrace();
        }
    }
}
