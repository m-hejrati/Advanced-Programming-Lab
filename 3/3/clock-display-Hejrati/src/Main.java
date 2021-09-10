/**
 * Main class is for testing the other class
 * @author Mahdi Hejrati 9723100
 * @since 2020.03.12
 *
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        ClockDisplay clock = new ClockDisplay();

        // get time from system
        GregorianCalendar gcalendar = new GregorianCalendar();
        int h = gcalendar.get(Calendar.HOUR_OF_DAY);
        int m = gcalendar.get(Calendar.MINUTE);
        int s = gcalendar.get(Calendar.SECOND);
        clock.setTime(h, m, s);

        // clock.setTime(5, 25, 59);

        System.out.println(clock.getTime());
        clock.timeTick();
        System.out.println(clock.getTime());
        clock.timeTick();
        System.out.println(clock.getTime());
    }
}