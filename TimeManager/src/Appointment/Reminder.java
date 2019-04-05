/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    Reminder class - Defines reminder object
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package Appointment;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sean J Curtis
 */

    public class Reminder {
    
    // For the current time
    private Calendar curtime;
    // This is the time you want to set the reminder for.
    private Calendar settime;
    
    /**
     * Parameterized Constructor
     * @param year int year
     * @param month int month
     * @param day int day
     * @param hour int hour
     * @param minute int minute
     * @param second  int second
     */
    public Reminder(int year, int month, int day, int hour, int minute, int second) {
        
        curtime = Calendar.getInstance();
        settime = Calendar.getInstance();
        settime.set(year, month, day, hour, minute, second);
        
    }
    
    /**
     * timeCheck - checks to see if the reminder time matches the current time
     * @return boolean if time is matched or not
     */
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
    /**
     * returns both current time and remind time
     * @return String of both times
     */
    public String returnTime() {
        Date cur;
        
        cur = curtime.getTime();
        
        
        String str = new String(cur.toString());
        
        return str;
    }
}
