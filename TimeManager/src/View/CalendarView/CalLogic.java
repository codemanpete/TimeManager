/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    CalLogic class - contains calendar logic
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.CalendarView;
import java.util.*;
import User.*;

/**
 *
 * @author Sean
 */
public class CalLogic {
    private Calendar today;
    private int month;
    private String[] MONTHNAMES = { "January", "February", "March", "April", 
                               "May", "June", "July", "August",
                               "September", "October", "November", "December" };
    
    private String[] WEEKDAYS = {"Sunday", "Monday", "Tuesday", "Wednesday",
                             "Thursday", "Friday", "Saturday"};
    
    private Calendar firstDayofMonth;
    private Calendar current;
    
    int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private User user;
    
    /**
     * Default Constructor
     * @param user - User object
     */
    public CalLogic(User user) {
        this.user = user;
        today = Calendar.getInstance();
        current = Calendar.getInstance();
        firstDayofMonth = Calendar.getInstance();
        firstDayofMonth.set(Calendar.DAY_OF_MONTH, 1);
                
    }
    /**
     * Constructor with month variable - to advance to a different month
     * @param month month variable
     */
    public CalLogic(int month) {
        this.month = month;
        today = Calendar.getInstance();
        current = Calendar.getInstance();
        today.set(Calendar.MONTH, month);
        firstDayofMonth = today;
        firstDayofMonth.set(Calendar.DAY_OF_MONTH, 1);
    }
    
    /**
     * getMonthName - returns a string of the month name
     * @return String month name
     */
    public String getMonthName() {
        return MONTHNAMES[today.get(Calendar.MONTH)];
    }
    /**
     * getYear - returns the current year
     * @return int of year
     */
    public int getYear() {
        return today.get(Calendar.YEAR);
    }
    /**
     * getFirstDay - returns the first day of the month
     * @return int of the first day of the month
     */
    public int getFirstDay() {
        return firstDayofMonth.get(Calendar.DAY_OF_WEEK);
    }
    /**
     * getDaysInMonth - returns the days in the current month
     * @return days in month
     */
    public int getDaysInMonth() {
        return DAYS_IN_MONTH[today.get(Calendar.MONTH)];
    }
    /**
     * getToday - returns current date
     * @return int for todays date
     */
    public int getToday() {
        
        return today.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * setMonth - changes calendar to month given
     * @param month int for the month needed
     */
    public void setMonth(int month) {
        this.month = month;
        today.set(Calendar.MONTH, month);
        firstDayofMonth = today;
        firstDayofMonth.set(Calendar.DAY_OF_MONTH, 1);
    }
    /**
     * getWeekDay - returns the day of the week
     * @return String day of week
     */
    public String getWeekDay() {
        return WEEKDAYS[today.get(Calendar.DAY_OF_WEEK)];
    }
    /**
     * getWeekDayInt - returnst he day of the week as an int
     * @return int day of the week
     */
    public int getWeekDayInt() {
        return today.get(Calendar.DAY_OF_WEEK);
    }
    /**
     * getWeekDay - returns a String for the week day
     * @param i day of the week needed
     * @return String week day
     */
    public String getWeekDay(int i) {
        return WEEKDAYS[i];
    }
    /**
     * getMonth - returns current month setting
     * @return int of the current month
     */
    public int getMonth() {
        return today.get(Calendar.MONTH);
    }
    /**
     * getAppointments - returns arraylist of todays appointments
     * @param day day needed
     * @return ArrayList of appointments
     */
    public ArrayList getAppointments(int day) {
        return user.getAppointments(today.get(Calendar.YEAR), today.get(Calendar.MONTH), day);
    }
    /**
     * getCurrent - returns current day (Today)
     * @return current Calendar object
     */
    public Calendar getCurrent() {
        return current;
    }

    
}
