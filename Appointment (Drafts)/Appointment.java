/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;
import java.util.*;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.YEAR;

/**
 *
 * @author Sean
 */
public class Appointment {

    /**
     * @param args the command line arguments
     */
    private Calendar startTime;
    private Calendar endTime;
    private String apptName;
    private ArrayList<String> userList;
    Reminder reminder;
    
    
    public Appointment(String name) {
        apptName = new String(name);
    }
    
    public void setStartTime(int year, int month, int day, int hour, int min) {
        if (year < 2019)
            throw new DateOutOfRangeException("Year in the past");
        if (month > 11 || month < 0)
            throw new DateOutOfRangeException("Month out of range");
        if (month == 1 && day > 28)
            throw new DateOutOfRangeException("Feb only has 28 Days");
        if ((month == 3 || month == 5 || month == 8 || month == 10) && day > 30)
            throw new DateOutOfRangeException("Apr, Jun, Sep, and Nov only have 30 days");
        if ((month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 10 || month == 12) && day > 31)
            throw new DateOutOfRangeException("Jan, Mar, May, Jul, Aug, Oct, Dec only have 31 days");
        
        startTime = Calendar.getInstance();
        startTime.set(year, month, day, hour, min);
    }
    
    public Date getStartTime() {
       
        return startTime.getTime();
    }
    
    public void setEndTime(int year, int month, int day, int hour, int min) {
        if (year < 2019)
            throw new DateOutOfRangeException("Year in the past");
        if (month > 11 || month < 0)
            throw new DateOutOfRangeException("Month out of range");
        if (month == 1 && day > 28)
            throw new DateOutOfRangeException("Feb only has 28 Days");
        if ((month == 3 || month == 5 || month == 8 || month == 10) && day > 30)
            throw new DateOutOfRangeException("Apr, Jun, Sep, and Nov only have 30 days");
        if ((month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 10 || month == 12) && day > 31)
            throw new DateOutOfRangeException("Jan, Mar, May, Jul, Aug, Oct, Dec only have 31 days");
        
        if (month > 11 || month < 0)
            throw new DateOutOfRangeException("Month out of range");
        
        endTime = Calendar.getInstance();
        endTime.set(year, month, day, hour, min);
    }
    
    public Date getEndTime() {
        return endTime.getTime();
    }
    
    public void setReminder(int min) {
        reminder = new Reminder(startTime.get(YEAR), 
                                startTime.get(MONTH), 
                                startTime.get(DAY_OF_MONTH), 
                                startTime.get(HOUR_OF_DAY), 
                                (startTime.get(MINUTE) - min), 
                                startTime.get(SECOND));
    }
    
    public boolean checkReminder() {
      
        return reminder.timeCheck();
    }
    
   
    
    
    
}
