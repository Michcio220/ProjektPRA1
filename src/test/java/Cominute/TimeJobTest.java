package Cominute;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class TimeJobTest {
    @Before
    public void setUp() throws Exception {
        LocalDateTime[] array; array = new LocalDateTime[12];
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dlugaPrzerwa = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 13, 15, 0);

        // Tworzy tablice zawierajaca godziny zajeć i przerw
        for (int i = 0; i < 12; i++) {
            if (i == 0) { array[i] = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 8, 15, 0); // poczatek zajeć
            } else if (i % 2 == 0 && i != 6) { array[i] = array[i - 1].plusMinutes(15); // przerwa
            } else if (i % 2 != 0) { array[i] = array[i - 1].plusMinutes(90); // zajecia
            } else if (i == 6) { array[i] = array[i - 1].plusMinutes(30); //długa przerwa
            }
        }
    }


    @Test
    public void execute() throws Exception {
        LocalDateTime[] array; array = new LocalDateTime[12];
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dlugaPrzerwa = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 13, 15, 0);

        // Tworzy tablice zawierajaca godziny zajeć i przerw
        for (int i = 0; i < 12; i++) {
            if (i == 0) { array[i] = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 8, 15, 0); // poczatek zajeć
            } else if (i % 2 == 0 && i != 6) { array[i] = array[i - 1].plusMinutes(15); // przerwa
            } else if (i % 2 != 0) { array[i] = array[i - 1].plusMinutes(90); // zajecia
            } else if (i == 6) { array[i] = array[i - 1].plusMinutes(30); //długa przerwa
            }
        }
        if (now.isAfter(array[0]) && now.isBefore(array[11])) {
            for (int i = 0; i < 12; i++) {
                if (now.isAfter(array[i]) && i % 2 != 0 && now.isBefore(array[i + 1])) {
                    Long diffrence = now.until(array[i + 1], ChronoUnit.MINUTES) + 1; //obliczanie czasu do konca przerwy
                    System.err.println("Do konca przerwy zostalo: " + diffrence.toString() + " min");
                    break; // przerywa petle
                } else if (now.isAfter(array[i]) && i % 2 == 0 && now.isBefore(array[i + 1])) {
                    Long diffrence = now.until(array[i + 1], ChronoUnit.MINUTES) + 1; // obliczanie czasu do konca zajec
                    System.err.println("Do konca zajec zostalo: " + diffrence.toString() + " min");
                    break; // przerywa petle
                }
            }
        }

    }
    @Test
    public void execute1() throws Exception{
        LocalDateTime[] array; array = new LocalDateTime[12];
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dlugaPrzerwa = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 13, 15, 0);

        // Tworzy tablice zawierajaca godziny zajeć i przerw
        for (int i = 0; i < 12; i++) {
            if (i == 0) { array[i] = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 8, 15, 0); // poczatek zajeć
            } else if (i % 2 == 0 && i != 6) { array[i] = array[i - 1].plusMinutes(15); // przerwa
            } else if (i % 2 != 0) { array[i] = array[i - 1].plusMinutes(90); // zajecia
            } else if (i == 6) { array[i] = array[i - 1].plusMinutes(30); //długa przerwa
            }
        }
        if (now.isAfter(array[0]) && now.isBefore(array[11])) {
            for (int i = 0; i < 12; i++) {
                if (now.isAfter(array[i]) && i % 2 != 0 && now.isBefore(array[i + 1])) {
                    Long diffrence = now.until(array[i + 1], ChronoUnit.MINUTES) + 1; //obliczanie czasu do konca przerwy
                    System.err.println("Do konca przerwy zostalo: " + diffrence.toString() + " min");
                    break; // przerywa petle
                } else if (now.isAfter(array[i]) && i % 2 == 0 && now.isBefore(array[i + 1])) {
                    Long diffrence = now.until(array[i + 1], ChronoUnit.MINUTES) + 1; // obliczanie czasu do konca zajec
                    System.err.println("Do konca zajec zostalo: " + diffrence.toString() + " min");
                    break; // przerywa petle
                }
            }
        }


    }

}