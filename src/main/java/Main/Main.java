package Main;

import Cominute.coMinute;
import Copolminuty.coPolMinuty;
import org.quartz.SchedulerException;

public class Main {
    public static void main(String [] arg) throws SchedulerException {
        try {
            coMinute obiekt2 = new coMinute();
            coPolMinuty obiekt1 = new coPolMinuty();
            obiekt1.execute();
            obiekt2.execute();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }
}
