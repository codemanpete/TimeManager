/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*   NewDayWindowPopUp class - Creates A Day Window Pop Up Window
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.CalendarDialog;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import Appointment.*;
import View.CalendarPanel.*;
/**
 *
 * @author Sean
 */
public class NewDayWindowPopUp extends JDialog {
    
       JLabel label;
        ArrayList<Appointment> appts;
    /**
     * Creates new form DayWindowPopUp
     */
    public NewDayWindowPopUp(java.awt.Frame parent, boolean modal, JLabel label, ArrayList appts) {
       
        super(parent, modal);
        this.appts = appts;
        this.label = label;
        initComponents();
    }
    /**
     * initComponents - draws components 
     */
    public void initComponents() {
        
        JLabel dayLabel = new javax.swing.JLabel();

        
        
        //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setLayout(new FlowLayout());
        
        dayLabel = label;
        JPanel topPanel = new JPanel(true);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(dayLabel);
        //dayLabel.setAlignmentY(Component.LEFT_ALIGNMENT);
        
        add(topPanel);
        
        JPanel bottomPanel = new JPanel(true);
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //bottomPanel.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        bottomPanel.setLayout(new FlowLayout());
        //JLabel apptName;
        
        for (Appointment a : appts) {
            ApptPanel apanel = new ApptPanel(a);
            System.out.println("added");
            bottomPanel.setVisible(true);
            bottomPanel.add(apanel);
            //repaint();
        }
        add(bottomPanel);
        
        pack();
    }
    
}
