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
import java.util.Calendar.*;

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
    Calendar date;
    
    /**
     * Creates new form DayWindowPopUp
     */
    public NewDayWindowPopUp(java.awt.Frame parent, boolean modal, JLabel label, ArrayList appts, User user, MainPanel main, Calendar date) { 
        super(parent, modal);
        this.appts = appts;
        this.label = label;
        this.user = user;
        this.main = main;
        this.date = date;
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
        dayLabel.setText((date.get(Calendar.MONTH) + 1) + "/" + label.getText());
        dayLabel.setHorizontalAlignment(JLabel.CENTER);
        JPanel topPanel = new JPanel(true);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.setLayout(new BorderLayout());
        topPanel.add(label, BorderLayout.NORTH);        
        addApptButton = new JButton("Add Appointment");
        topPanel.add(addApptButton);
        add(topPanel);
        
        // addApptButton prompts user to add an appointment
        addApptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                AddAppointmentDialog apptDialog = new AddAppointmentDialog(frame, true, user, main, date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
                apptDialog.setLocationRelativeTo(frame);
                apptDialog.setVisible(true);
            }
        });

        for (int i = 0; i < 24; i++) {
            JPanel panel = new JPanel(true);
            panel.setBorder(BorderFactory.createLineBorder(Color.black));
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
           // panel.setVisible(true);
            JLabel label = new JLabel(i + ":00");
            panel.add(label);
            for (Appointment a : appts) {
                if (a.getStartTime().get(Calendar.HOUR_OF_DAY) <= i && a.getEndTime().get(Calendar.HOUR_OF_DAY) >= i) {
                    
                    ApptPanel apanel = new ApptPanel(a);
                    // Add option to delete appointments
                    delButton = new JButton("Delete");
                   
                    apanel.add(delButton);
                    panel.add(apanel);
                    add(panel);
            delButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This removes the database appointment
                    AppointmentDB apptDB = new AppointmentDB("jdbc:sqlite:user.db");
                    int id = apptDB.getRowID(a);
                    if(id==0){
                        JOptionPane.showMessageDialog(main,"There are multiple appointments with that name. Please choose.",
                        "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        // This removes the appointment from the DB
                        apptDB.delAppt(id);
                        // This removes the visible appointment from the arraylist of appointments
                        user.remAppointment(a);
                    }
                    // This repaints the window
                    main.paintComponent();
                }
            });
                    
                    
                    
                }
            }
            
             
            
            add(panel);
        }
        
        /*
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
                    int id = apptDB.getRowID(a);
                    if(id==0){
                        JOptionPane.showMessageDialog(main,"There are multiple appointments with that name. Please choose.",
                        "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        // This removes the appointment from the DB
                        apptDB.delAppt(id);
                        // This removes the visible appointment from the arraylist of appointments
                        user.remAppointment(a);
                    }
                    // This repaints the window
                    main.paintComponent();
                }
            });
        } */
        pack();
    } 
    
    

}
