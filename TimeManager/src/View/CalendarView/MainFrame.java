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
import java.util.ArrayList;

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
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Contact");
        JMenuItem global = new JMenuItem("Global");
        JMenuItem addAppt = new JMenuItem("Add Appointment");
        JMenuItem addUser = new JMenuItem("Add User");
        JMenuItem exitProgram = new JMenuItem("Exit");
        addAppt.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Add Appointment");
                AddAppointmentDialog apptDialog = new AddAppointmentDialog(frame, true, user, main);
                apptDialog.setLocationRelativeTo(frame);
                apptDialog.setVisible(true);
            }
        });
        
        addUser.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Add user");
                AddUserDialog userDialog = new AddUserDialog(frame, true);
                userDialog.setLocationRelativeTo(frame);
                userDialog.setVisible(true);
            }
        });
        
        exitProgram.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.println("Add user");
                System.exit(0);
            }
        });
        
        global.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
               UserDB udb = new UserDB("jdbc:sqlite:user.db");
               ArrayList<User> users = udb.getAllUsers();
               JFrame contact = new JFrame("Contact List");
               contact.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               contact.setSize(200, 200);
               contact.setLayout(new BorderLayout());
               JPanel panel = new JPanel(true);
               panel.setLayout(new GridLayout(0, 1));
               
               for (User a : users) {
                   JPanel user = new JPanel();
                   JLabel label1 = new JLabel();
                   JLabel label2 = new JLabel();
                   label1.setText(" " + a.getIdNumber());
                   label2.setText(a.getUserName());
                   user.add(label1);
                   user.add(label2);
                   panel.add(user);
               }
               contact.add(panel);
               contact.setVisible(true);
               
            }
        });
        
        menu1.add(addAppt);
        menu1.addSeparator();
        menu1.add(addUser);
        menu1.addSeparator();
        menu1.add(exitProgram);
        menu2.add(global);
        menuBar.add(menu1);
        menuBar.add(menu2);
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
