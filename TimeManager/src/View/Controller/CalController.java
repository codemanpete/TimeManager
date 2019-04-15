/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    CalController class - controls the main panel
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.Controller;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import View.CalendarView.*;

/**
 *
 * @author Sean
 */
public class CalController extends JPanel {
    private MainPanel panel;
    private CalLogic model;
    boolean monthOrWeek;
    private JButton monthSwitch;
    private JButton prevMonth;
    private JButton nextMonth;
    
    /**
     * Default Constructor
     * @param panel MainPanel object
     * @param model CalLogic object
     */
    public CalController(MainPanel panel, CalLogic model) {
        this.panel = panel;
        this.model = model;
        monthOrWeek = true;
        //JPanel controller = new JPanel(true);
        //this.setLayout(new GridLayout(2, 2));
        //this.setLayout(new FlowLayout);
        this.setLayout(new BorderLayout());
        
        
        
        
        
        nextMonth = new JButton();
        nextMonth.setText("Next");
        nextMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monthOrWeek) {
                    int next = model.getMonth();
                    next++;
                    model.setMonth(next);
                    panel.nextMonth();
                } else {
                    panel.incrementWeek();
                }
            }
        });
        
        
        prevMonth = new JButton();
        prevMonth.setText("Prev");
        prevMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monthOrWeek) {
                    int prev = model.getMonth();
                    prev--;
                    model.setMonth(prev);
                    panel.nextMonth();
                } else {
                    panel.decrementWeek();
                }
            }
        });
        buttonInit();
        //add(prevMonth);
        //add(weekSwitch);
        //add(monthSwitch);
        //add(nextMonth);
        
        
        setVisible(true);
        
        
        
    }
    
    
    /**
     * buttonInit - creates the buttons dynamically
     */
    private void buttonInit() {
        //remove(monthSwitch);
        if (monthOrWeek) {
        monthSwitch = new JButton();    
        monthSwitch.setText("Week");
        monthSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.changeWeek();
                monthOrWeek = false;
                buttonInit();
                
            }
        });
        }
        else {
        monthSwitch = new JButton();
        monthSwitch.setText("Month");
        monthSwitch.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.changeMonth();
                monthOrWeek = true;
                buttonInit();
                
            }
        });
        }
        removeAll();
        add(prevMonth, BorderLayout.WEST);
        add(monthSwitch, BorderLayout.CENTER);
        add(nextMonth, BorderLayout.EAST);
        revalidate();
        repaint();
      
    }
    
}
