/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    ApptPanel class - Creates a panel to display appointments
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
import Appointment.*;
/**
 *
 * @author Sean
 */
public class ApptPanel extends JPanel{
    private Appointment appt;
    /**
     * Default Constructor
     * @param appt Appointment object
     */
    public ApptPanel(Appointment appt) {
        this.appt = appt;
        this.add(makePanel());
    }
    
    /**
     * makePanel - creates the panel
     * @return a Jpanel
     */
    private JPanel makePanel() {
        JPanel panel = new JPanel(true);
        //panel.setLayout(new FlowLayout());
        //panel.setPreferredSize(new Dimension(10, 10));
        JLabel apptName = new JLabel(appt.getApptName());
        JLabel startTime  = new JLabel((appt.getStartTime().get(Calendar.HOUR_OF_DAY)) + 
                                        ":" + (appt.getStartTime().get(Calendar.MINUTE) + "0"));
        
       
        
        JLabel stopTime  = new JLabel((appt.getEndTime().get(Calendar.HOUR_OF_DAY)) + 
                                        ":" + (appt.getEndTime().get(Calendar.MINUTE) + "0"));
        JLabel apptID = new JLabel(" " + appt.getAppointmentID());
        panel.add(apptName);
        panel.add(startTime);
        
        panel.add(stopTime);
        //panel.add(apptID);
        return panel;
    }
    
    
}
