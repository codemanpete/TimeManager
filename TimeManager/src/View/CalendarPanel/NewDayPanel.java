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
    CalLogic model;
    JFrame topFrame;
    User user;
    MainPanel main;
    ArrayList<Appointment> todaysAppts = new ArrayList();
        
    /**
     * NewDayPanel default constructor
     * @param label day label
     * @param model CalendarLogic class
     */
    public NewDayPanel(JLabel label, CalLogic model, User user, MainPanel main) {
        this.model = model;
        this.label = label;
        this.user = user;
        this.main = main;
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        getTodaysAppts(label);
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
        topPanel.add(dayLabel);
        add(topPanel);
        JLabel apptName;
        
        for (Appointment a : todaysAppts) {
            ApptPanel apanel = new ApptPanel(a);
            add(apanel);
            repaint();
        }	
    }                       
/**
 * formMouseClicked - allows day panels to be clicked on
 * @param evt 
 */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        // System.out.println(label.getText());
        NewDayWindowPopUp pop = new NewDayWindowPopUp(topFrame, true, label, todaysAppts, user, main);
        pop.setLocationRelativeTo(topFrame);
        pop.setVisible(true);
    }
    /**
     * getTodaysAppts - gets the appts from the User arraylist
     * @param label 
     */
    private void getTodaysAppts(JLabel label) {
        String today = label.getText();
        Integer td = Integer.parseInt(today.trim());
        ArrayList<Appointment> temp = model.getAppointments(td);    
        for (Appointment t : temp) {   
            Calendar day = t.getStartTime();
            if (t != null){
                if (day.get(Calendar.DATE) == td) {
                    todaysAppts.add(t);
                }
            } 
        }
    }
}
