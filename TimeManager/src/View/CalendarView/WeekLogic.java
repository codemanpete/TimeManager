/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    CalLogic class - contains logic for building week view
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.CalendarView;
import java.util.*;

/**
 *
 * @author Peter
 */
public class WeekLogic {
    private Calendar firstDayOfWeek;
    private Calendar today;
    private String[] MONTH_NAMES = { "January", "February", "March", "April", 
                           "May", "June", "July", "August",
                           "September", "October", "November", "December" };
    
    /**
     * Default Constructor
     * 
     */
    public WeekLogic() {
        today = Calendar.getInstance();
        firstDayOfWeek = getLastSunday(Calendar.getInstance());
    }
    
    public String getMonthName() {
        return MONTH_NAMES[firstDayOfWeek.get(Calendar.MONTH)];
    }
    
    public int getYear() {
        return firstDayOfWeek.get(Calendar.YEAR);
    }
    
    public Calendar getFirstDayOfWeek() {
        return (Calendar) firstDayOfWeek.clone();
    }
    
    /**
     * Returns the first Sunday
     */
    private Calendar getLastSunday(Calendar date) {
        Calendar thisDay = (Calendar) date.clone();
        while (thisDay.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            thisDay.add(Calendar.DATE, -1);
        }
        return thisDay;
    }
    
    /**
     * Returns the previous day without modifying input
     * @param date - day
     */
    private Calendar getYesterday(Calendar date) {
        Calendar yesterday = (Calendar) date.clone();
        yesterday.add(Calendar.DATE, -1);
        return yesterday;
    }
    
    /**
     * Returns the next day without modifying input
     * @param date - day
     */
    private Calendar getTomorrow(Calendar date) {
        Calendar tomorrow = (Calendar) date.clone();
        tomorrow.add(Calendar.DATE, 1);
        return tomorrow;
    }
    
    /**
     * 
     */
    public void incrementWeek() {
        this.firstDayOfWeek.add(Calendar.DATE, 7);
    }
    
    /**
     * 
     */
    public void decrementWeek() {
        this.firstDayOfWeek.add(Calendar.DATE, -7);
    }
}


