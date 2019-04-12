/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    MonthView - creates month calendar view
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
import java.util.*;
import View.CalendarPanel.*;
import User.*;

/**
 *
 * @author Sean
 */
public class MonthView extends JPanel {
   private Calendar today = Calendar.getInstance();
   int month;
   CalLogic model;
   int td;
   User user;
   MainPanel main;
    /**
     * Default Constructor
     * @param model model object
     */
    public MonthView(CalLogic model, User user, MainPanel main) {
        month = today.get(Calendar.MONTH);
        this.model = model;
        this.user = user;
        this.main = main;
        this.add(makePanel());
    }
    /**
     * Constructor with month variable, to change to a different month
     * @param month int variable
     */
    public MonthView(int month) {
        this.add(makePanel());
    }
    /**
     * makePanel - creates the main panel
     * @return JPanel of the calendar panel
     */
    public JPanel makePanel() {
        JPanel panel = new JPanel(true);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setSize(300, 300);
        panel.add(makeTopPanel(), BorderLayout.NORTH);
        panel.add(makeCalendarPanel(), BorderLayout.CENTER);
        return panel;
    }
    /**
     * makeTopPanel - creates the label panel
     * @return a JPanel of the label
     */
    private JPanel makeTopPanel() {
        today.set(Calendar.MONTH, (month));
        JPanel panel = new JPanel(true);
        panel.setBorder(BorderFactory.createBevelBorder(1));
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.white);
        JLabel label = new JLabel(model.getMonthName() + " " + model.getYear());
        label.setForeground(Color.red);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
    /**
     * makeCalendarPanel - creates the actual calendar panel
     * @return a JPanel for the Calendar
     */
    private JPanel makeCalendarPanel() {
        int daysInMonth;
        
        if (model.isLeap() == true) {
            daysInMonth = model.getDaysInMonthLeap();
        }
        else {daysInMonth = model.getDaysInMonth();}
        
       
        
        
        JPanel panel = new JPanel(true);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new GridLayout(0, 7));
        if (model.getCurrent().get(Calendar.YEAR) == model.getYear() && 
                model.getCurrent().get(Calendar.MONTH) == model.getMonth()) {
            td = model.getCurrent().get(Calendar.DAY_OF_MONTH);
        }
        else {
            td = 0;
        }
        for (int i = 0; i < 7; i++) {
            JPanel panels = new JPanel(true);
            panels.setBorder(BorderFactory.createLineBorder(Color.black));
            JLabel labels = new JLabel(model.getWeekDay(i));
            panels.setPreferredSize(new Dimension(175, 50));
            panels.add(labels, BorderLayout.NORTH);
            panel.add(panels);
        }
        for (int i = 1; i <= (daysInMonth + model.getFirstDay() - 1); i++) {
            if (i < (model.getFirstDay()  )) {
                JPanel panels = new JPanel(true);
                panels.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(panels);
            }
            else {
            JLabel labels = new JLabel((i - (model.getFirstDay() - 1))+ " ");
            labels.setAlignmentY(Component.LEFT_ALIGNMENT);
            if ((i - (model.getFirstDay() - 1)) == td) {
                labels.setForeground(Color.red);
            }
                NewDayPanel panels = new NewDayPanel(labels, model, user, main);
                panels.setBorder(BorderFactory.createLineBorder(Color.black));
                panels.setPreferredSize(new Dimension(175, 125));
                panel.add(panels);
            }
        }
        return panel;
    }
    /**
     * getMonth - returns current month variable
     * @return int for the current month
     */
    public int getMonth() {
        return month;
    }
    /**
     * addMonth - increments month variable (Deprecated)
     */
    public void addMonth() {
        int td = today.get(Calendar.MONTH);
        td++;
        today.set(Calendar.MONTH, td);
        //System.out.println(today.get(Calendar.MONTH));
        
       
    }
}
