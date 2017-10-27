package Timer;


import ZapiszDoPliku.SqlAns;
import org.quartz.SchedulerException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CoMinute {

    public static void main(String[] arg) throws SchedulerException, FileNotFoundException {

        Pattern p = Pattern.compile("\\d\nSELECT\nFROM");

        String wzorzecTest = "SELECT";

        String wzorzec1 = "\\d\n" + "SELECT\n" + "FROM";
        String wzorzec2 = "\\d\nSELECT\nFROM\nWHERE";
        String wzorzec3 = "\\d\nSELECT\nFROM\nWHERE\nORDER BY";

        Scanner odczyt = new Scanner(System.in);

        StringBuilder zdanie = new StringBuilder();

        SqlAns MyObject = new SqlAns();

        int x = odczyt.nextInt();

        MyObject.setNumber(x);

        zdanie.append(x);


        for(int i =0; i < 3; i++) {

            if(i != 2) {

                zdanie.append(odczyt.nextLine()).append("\n");

            }else{

                zdanie.append(odczyt.nextLine());

            }
        }

        String zdanieString = zdanie.toString();
        MyObject.setCiagPolecen(zdanieString);

        odczyt.close();

        PrintWriter writer = new PrintWriter("C:/Users/admin/Desktop/Projekt na Zajecia/ProjektPRA1//Odp.txt");

        writer.println("Witam 1");

        System.out.println(MyObject.getCiagPolecen());
        writer.println(MyObject.getCiagPolecen());
    }
}
