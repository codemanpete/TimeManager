/*
 * Reminder class. Lets programmer set a simple reminder and check
 * to see if that future time matches the current time
 * Sean J Curtis
 */
package reminder;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Sean J Curtis
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Simple driver
        
        Reminder remind = new Reminder(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 
                                        Integer.parseInt(args[2]), Integer.parseInt(args[3]),
                                        Integer.parseInt(args[4]), Integer.parseInt(args[5]));
        
        System.out.println(remind.returnTime());
        
        while(!remind.timeCheck()) {
            System.out.println("Not Yet");
          // remind.returnTime();
        //   System.out.println(remind.timeCheck());
                    
        }
        System.out.println("Now");
    }
    
}
