/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    MainPanel class - Creates a panel in main frame to display the calendar
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.CalendarView;
import java.awt.*;
import javax.swing.*;
import User.*;

/**
 *
 * @author Sean
 */
public class MainPanel extends JPanel {
    JPanel calPanel;
    CalLogic model;
    User user;
    WeekLogic weekModel;
    boolean weekOrMonth;
    /**
     * Default Constructor
     * @param model model object
     * @param user User object
     */
    public MainPanel(CalLogic model, User user) {
        setLayout(new CardLayout());
        this.model = model;
        this.weekModel = new WeekLogic();
        this.user = user;
        this.calPanel = new MonthView(model, user, this);
        weekOrMonth = false;
        add(calPanel);   
    }
    /**
     * changeWeek - changes to week view
     */
    public void changeWeek() {
        removeAll();
        this.calPanel = new WeekView(weekModel, user, this);
        weekOrMonth = true;
        add(calPanel);
        revalidate();
        repaint();  
    }
    /**
     * changeMonth - changes to month view
     */
    public void changeMonth() {
        removeAll();
        this.calPanel = new MonthView(model, user, this);
        weekOrMonth = false;
        add(calPanel);
        revalidate();
        repaint();  
    }
    /**
     * nextMonth - advances calendar
     */
    public void nextMonth() {
      removeAll();
      add(calPanel = new MonthView(model, user, this));
      revalidate();
      repaint();
    }
    /**
     * paintComponent - repaints the view
     */
    public void paintComponent() {
        removeAll();
        if (!weekOrMonth) {
            add(calPanel = new MonthView(model, user, this));
        }
        else {
            add(calPanel = new WeekView(weekModel, user, this));
        }
        
        //add(calPanel);
        revalidate();
        repaint();
    }
    
    /**
     * incrementWeek - increments the week variable
     */
    public void incrementWeek() {
        removeAll();
        weekModel.incrementWeek();
        this.calPanel = new WeekView(weekModel, user, this);
        add(calPanel);
        revalidate();
        repaint();
    }
    
    /**
     * decrementWeek - decrements the week variable
     * 
     */
    public void decrementWeek() {
        removeAll();
        weekModel.decrementWeek();
        this.calPanel = new WeekView(weekModel, user, this);
        add(calPanel);
        revalidate();
        repaint();
    }
}
