/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    WeekView - creates a week view calendar
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.CalendarView;

import User.*;
import View.CalendarPanel.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;

/**
 *
 * @author Sean
 */
public class WeekView extends JPanel {
    private Calendar today = Calendar.getInstance();
    private String[] WEEKDAYS = {"Sunday", "Monday", "Tuesday", "Wednesday",
                             "Thursday", "Friday", "Saturday"};
    WeekLogic model;
    User user;
    MainPanel main;
    /**
     * Default Constructor
     * @param model WeekLogic object
     */    
    public WeekView(WeekLogic model, User user, MainPanel main) {
        this.model = model;
        this.user = user;
        this.main = main;
        this.add(makePanel());
    }
    /**
     * makePanel - creates the main panel
     * @return JPanel for the week view
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
     * makeTopPanel - creates the top label panel
     * @return JPanel for the top panel
     */
    private JPanel makeTopPanel() {
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
     * makeCalendarPanel - creates the calendar panel
     * @return a JPanel for the calendar
     */
    private JPanel makeCalendarPanel() {
        JPanel panel = new JPanel(true);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new GridLayout(0, 7));
        
        //int td = today.get(Calendar.DAY_OF_WEEK);
        //int td = model.getWeekDayInt();
        Calendar dateMaker = model.getFirstDayOfWeek();
        for (int i = 0; i < 7; i++) {
            
            JLabel heading = new JLabel(" " + WEEKDAYS[i] + " " + (dateMaker.get(Calendar.MONTH) +1) + "/" + dateMaker.get(Calendar.DAY_OF_MONTH));
            Calendar date = (Calendar) dateMaker.clone();
            NewDayPanel dayPanel = new NewDayPanel(heading, user, main, date);
            //JPanel dayPanels = new JPanel(true);
            dayPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            dayPanel.setPreferredSize(new Dimension(175, 600));
           
           
            /*if (i == td - 1) {
                labels.setForeground(Color.red);
            }
            */
            //dayPanel.add(heading, BorderLayout.NORTH);
            panel.add(dayPanel);
            dateMaker.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        return panel;
    }

}
