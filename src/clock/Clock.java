package clock;

import java.text.*;
import java.util.*;

public class Clock extends TimerTask{
    
    private int hours, minutes, seconds;
    private NumberFormat twoDigits = new DecimalFormat("00");
    private boolean showSeconds = true;
    
    public Clock(int h, int m, int s) {
        hours = h;
        minutes = m;
        seconds = s;
    }
    
    public Clock tickOneSecond(Clock c) {
        c.seconds = c.seconds + 1;
        if (c.seconds == 60) {
            c.seconds = 0;
            minutes = c.minutes + 1;
        }
        if (c.minutes == 60) {
            c.minutes = 0;
            c.hours = c.hours + 1;
        }
        if (c.hours == 24) {
            c.hours = 0;
        }
        
        return c;
        
    }
    
    public void startClock(Clock c) {
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
            public void run() {
                c.tickOneSecond(c);
            }
        }, 0, 1000);
    }
    
    public void toggleShowSeconds(Clock c) {
        
        if (c.showSeconds == true) {
        c.showSeconds = false;
        }
        
        else {
            c.showSeconds = true;
        }
        
    }
    
    public String getCurrentTime(Clock c) {
        String currentTime = "";
        if (c.showSeconds == false) {
            currentTime = (twoDigits.format(c.hours) + ":" + twoDigits.format(c.minutes));
        }
        
        else {
            currentTime = (twoDigits.format(c.hours) + ":" + twoDigits.format(c.minutes) + ":" + twoDigits.format(c.seconds));
        }
        return currentTime;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
