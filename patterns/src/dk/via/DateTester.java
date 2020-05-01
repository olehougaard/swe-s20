package dk.via;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTester {
    public static void main(String[] args) throws Exception {
        // In 1973:
        Date oldDays = new Date(73, 5, 1);
        // Today:
        Date today = new Date(120, Calendar.MAY, 1);


        GregorianCalendar yesterday = new GregorianCalendar(2020, Calendar.APRIL, 31);
        System.out.println(yesterday.getTime());
    }
}
