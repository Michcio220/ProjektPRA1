package Copolminuty;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Nie wiedzialem niestety jak zrobic testy do metod jakich wykorzystalem
public class coPolMinutyTest {

    coPolMinuty obiekt;

    @Before
    public void setUp() throws Exception {

        obiekt = new coPolMinuty();
    }

    @Test
    public void matches() throws Exception {

        String wzorzec1 = "SELECT FROM"; //wzorce poleceń sql
        String wzorzec2 = "SELECT FROM WHERE";
        String wzorzec3 = "SELECT FROM WHERE ORDER BY";
        String wzorzec4 = "SELECT FROM ORDER BY";
        String zdanie = "SELECT FROM";
        obiekt.matches(zdanie,wzorzec1);

    }

}