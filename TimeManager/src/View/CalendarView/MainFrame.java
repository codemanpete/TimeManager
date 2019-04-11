/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    MainFrame creates main GUI panel
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.CalendarView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.*;
import View.Controller.*;
import User.*;
import View.CalendarDialog.*;

/**
 *
 * @author Sean
 */
public class MainFrame extends JFrame {
    private CalLogic model;
    private MainPanel main;
    private CalController control;
    private User user;
    /**
     * Default Constructor
     * @param user User object
     */
    public MainFrame(User user) {
        this.user = user;
        model = new CalLogic(user);
        this.main = new MainPanel(model, user);
        JFrame frame = new JFrame();
        control = new CalController(main, model);
        control.setBorder(BorderFactory.createBevelBorder(1));
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem addAppt = new JMenuItem("Add Appointment");
        JMenuItem addUser = new JMenuItem("Add User");
        addAppt.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Appointment");
                AddAppointmentDialog apptDialog = new AddAppointmentDialog(frame, true, user, main);
                apptDialog.setLocationRelativeTo(frame);
                apptDialog.setVisible(true);
            }
        });
        addUser.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add user");
                AddUserDialog userDialog = new AddUserDialog(frame, true);
                userDialog.setLocationRelativeTo(frame);
                userDialog.setVisible(true);
            }
        });
        menu.add(addAppt);
        menu.addSeparator();
        menu.add(addUser);
        menuBar.add(menu);
        frame.setTitle("Time Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(menuBar);
        frame.add(control, BorderLayout.NORTH);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * changeWeek - Switch to week calendar (Deprecated)
     */
    public void changeWeek() {
    }
    /**
     * changeMonth - change to month calendar (Deprecated)
     */
    public void changeMonth() {
        this.repaint();
    }
    
    /**
     * actionPerformed
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        
    }
}
