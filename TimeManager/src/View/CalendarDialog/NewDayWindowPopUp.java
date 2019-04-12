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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import User.*;
import View.CalendarView.MainPanel;

/**
 *
 * @author Sean
 */
public class NewDayWindowPopUp extends JDialog {
    JButton delButton, addApptButton;
    JLabel label;
    ArrayList<Appointment> appts;
    User user;
    MainPanel main;
    JFrame frame;
    /**
     * Creates new form DayWindowPopUp
     */
    public NewDayWindowPopUp(java.awt.Frame parent, boolean modal, JLabel label, ArrayList appts, User user, MainPanel main) { 
        super(parent, modal);
        this.appts = appts;
        this.label = label;
        this.user = user;
        this.main = main;
        initComponents();
    }
    /**
     * initComponents - draws components 
     */
    public void initComponents() {
        // General Layout is vertically oriented
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        // Add components to panels
        JLabel dayLabel = new javax.swing.JLabel();
        dayLabel = label;
        JPanel topPanel = new JPanel(true);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(dayLabel);        
        addApptButton = new JButton("Add Appointment");
        topPanel.add(addApptButton);
        add(topPanel);
        
        // addApptButton prompts user to add an appointment
        addApptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAppointmentDialog apptDialog = new AddAppointmentDialog(frame, true, user, main);
                apptDialog.setLocationRelativeTo(frame);
                apptDialog.setVisible(true);
            }
        });

        for (Appointment a : appts) {
            // bottomPanel will hold all appointments
            JPanel bottomPanel = new JPanel(true);
            bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            bottomPanel.setLayout(new FlowLayout());
            bottomPanel.setVisible(true);
            // Display all appointments
            ApptPanel apanel = new ApptPanel(a);
            bottomPanel.add(apanel);
            // Add option to delete appointments
            delButton = new JButton("Delete");
            bottomPanel.add(delButton);
            add(bottomPanel);
            delButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This removes the database appointment
                    AppointmentDB apptDB = new AppointmentDB("jdbc:sqlite:user.db");
                    apptDB.delAppt(a);
                    // This removes the visible appointment
                    user.remAppointment(a);
                    // This repaints the window
                    main.paintComponent();
                }
            });
        }
        pack();
    }  
}
