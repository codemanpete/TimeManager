/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sean
 */

    public class Reminder {
    
    // For the current time
    private Calendar curtime;
    // This is the time you want to set the reminder for.
    private Calendar settime;
    
    // Constructor sets the set time.
    public Reminder(int year, int month, int day, int hour, int minute, int second) {
        
        curtime = Calendar.getInstance();
        settime = Calendar.getInstance();
        settime.set(year, month, day, hour, minute, second);
        
    }
    
    // Really simple check function, returns true if the current time matches
    // the time set by the constructor
    public boolean timeCheck() {
        
        curtime = Calendar.getInstance();
        
        Date cur;
        Date set;
        
        cur = curtime.getTime();
        set = settime.getTime();
        
        if (curtime.compareTo(settime) >= 0) {
            return true;
        }
        
        else {
            return false;
        }
    }
    // Prints both time values, useful for debugging
    public String returnTime() {
        Date cur;
        
        cur = curtime.getTime();
        
        
        String str = new String(cur.toString());
        
        return str;
    }
}
