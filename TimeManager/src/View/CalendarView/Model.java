/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.CalendarView;
import java.util.*;
import User.*;

/**
 *
 * @author Sean
 */
public class Model {
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
    
    
    public Model(User user) {
        this.user = user;
        today = Calendar.getInstance();
        current = Calendar.getInstance();
        firstDayofMonth = Calendar.getInstance();
        firstDayofMonth.set(Calendar.DAY_OF_MONTH, 1);
                
    }
    
    public Model(int month) {
        this.month = month;
        today = Calendar.getInstance();
        current = Calendar.getInstance();
        today.set(Calendar.MONTH, month);
        firstDayofMonth = today;
        firstDayofMonth.set(Calendar.DAY_OF_MONTH, 1);
    }
    
    
    public String getMonthName() {
        return MONTHNAMES[today.get(Calendar.MONTH)];
    }
    
    public int getYear() {
        return today.get(Calendar.YEAR);
    }
    
    public int getFirstDay() {
        return firstDayofMonth.get(Calendar.DAY_OF_WEEK);
    }
    
    public int getDaysInMonth() {
        return DAYS_IN_MONTH[today.get(Calendar.MONTH)];
    }
    
    public int getToday() {
        
        return today.get(Calendar.DAY_OF_MONTH);
    }
    
    public void setMonth(int month) {
        this.month = month;
        today.set(Calendar.MONTH, month);
        firstDayofMonth = today;
        firstDayofMonth.set(Calendar.DAY_OF_MONTH, 1);
    }
    
    public String getWeekDay() {
        return WEEKDAYS[today.get(Calendar.DAY_OF_WEEK)];
    }
    
    public int getWeekDayInt() {
        return today.get(Calendar.DAY_OF_WEEK);
    }
    
    public String getWeekDay(int i) {
        return WEEKDAYS[i];
    }
    
    public int getMonth() {
        return today.get(Calendar.MONTH);
    }
    
    public ArrayList getAppointments(int day) {
        return user.getAppointments(today.get(Calendar.YEAR), today.get(Calendar.MONTH), day);
    }
    
    public Calendar getCurrent() {
        return current;
    }

    
}
