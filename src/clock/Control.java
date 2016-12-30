package clock;

import java.util.*;
import javax.swing.JFrame;

public class Control extends JFrame{
    
    public static Calendar dateToday = Calendar.getInstance();
    public static Clock c1;
    private static Interface showTime;

    public static void main(String[] args) {
        
        c1 = new Clock(dateToday.get(Calendar.HOUR_OF_DAY), dateToday.get(Calendar.MINUTE), dateToday.get(Calendar.SECOND));
        showTime = new Interface();
        c1.startClock(c1);
        
    }
    
}
