/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    NewDayPanel class - Creates day panels for the calendar
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.CalendarPanel;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import View.CalendarView.*;
import Appointment.*;
import View.CalendarDialog.*;
import User.*;

/**
 *
 * @author Sean
 */
public class NewDayPanel extends JPanel{
    JLabel label;
    Calendar date;
    JFrame topFrame;
    User user;
    MainPanel main;
    ArrayList<Appointment> todaysAppts = new ArrayList();
        
    /**
     * NewDayPanel default constructor
     * @param label day label
     */
    public NewDayPanel(JLabel label, User user, MainPanel main, Calendar date) {
        this.label = label;
        this.user = user;
        this.main = main;
        this.date = date;
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        getTodaysAppts(date);
        initComponents();
    }
        /**
         * initComponenets - create the panel
         */
    private void initComponents() {
        JLabel dayLabel = new javax.swing.JLabel();
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        dayLabel = label;
        JPanel topPanel = new JPanel(true);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(label);
        //add(topPanel);
        JLabel apptName;
        
        for (Appointment a : todaysAppts) {
            ApptPanel apanel = new ApptPanel(a);
            //add(apanel);
            JLabel appointmentLabel = new JLabel(a.getStartTime().get(Calendar.HOUR_OF_DAY) + 
                                        ":" + a.getStartTime().get(Calendar.MINUTE) + "0 "
                                                + a.getApptName());
            appointmentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            topPanel.add(appointmentLabel);
        }
        add(topPanel);
        repaint();
    }                       
/**
 * formMouseClicked - allows day panels to be clicked on
 * @param evt 
 */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        // System.out.println(label.getText());
        NewDayWindowPopUp pop = new NewDayWindowPopUp(topFrame, true, label, todaysAppts, user, main, date);
        pop.setLocationRelativeTo(topFrame);
        pop.setVisible(true);
    }
    /**
     * getTodaysAppts - gets the appts from the User arraylist
     * @param label 
     */
    private void getTodaysAppts(Calendar date) {
        //String today = label.getText();
        //Integer td = Integer.parseInt(today.trim());
        
        Calendar tdStart = (Calendar) date.clone();
        Calendar tdEnd = (Calendar) date.clone();
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DATE);
        tdStart.set(year, month , day, 0, 0, 0);
        tdEnd.set(year, month, day, 23, 59, 59);
        
        ArrayList<Appointment> allApts = user.getAllAppointments(); 
        
        for (Appointment t : allApts) {   
            Calendar sday = t.getStartTime();
            Calendar eday = t.getEndTime();
            if (t != null)
                if (sday.compareTo(tdEnd) <= 0)
                    if(eday.compareTo(tdStart) >= 0) 
                        todaysAppts.add(t);
        }
    }
}
