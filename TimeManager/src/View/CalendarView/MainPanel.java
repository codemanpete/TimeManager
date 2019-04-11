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
    //MonthView mpanel;
   // WeekView wpanel;
    JPanel calPanel;
    CalLogic model;
    
    
    
    /**
     * Default Constructor
     * @param model model object
     * @param user User object
     */
    public MainPanel(CalLogic model, User user) {
        //setPreferredSize(new Dimension(1500, 1500));
        setLayout(new CardLayout());
        this.model = model;
        
        this.calPanel = new MonthView(model);
        
       // this.mpanel = mpanel;
        //this.wpanel = wpanel;
        //add(wpanel);
        add(calPanel);
        
    }
    /**
     * changeWeek - changes to week view
     */
    public void changeWeek() {
        removeAll();
        this.calPanel = new WeekView(model);
        add(calPanel);
        revalidate();
        repaint();
        
        
    }
    /**
     * changeMonth - changes to month view
     */
    public void changeMonth() {
        removeAll();
        this.calPanel = new MonthView(model);
        add(calPanel);
        revalidate();
        repaint();
        
    }
    /**
     * nextMonth - advances calendar
     */
    public void nextMonth() {
        
      removeAll();
      add(calPanel = new MonthView(model));
      revalidate();
      repaint();
    }
    /**
     * paintComponent - repaints the view
     */
    public void paintComponent() {
        removeAll();
        add(calPanel = new MonthView(model));
        revalidate();
        repaint();
    }
    
}
