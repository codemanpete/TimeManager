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
   // private MonthView mpanel;
   // private WeekView wpanel;
    //JPanel calPanel;
    private Model model;
    private MainPanel main;
   
    private CalController control;
    private User user;
    
    /**
     * Default Constructor
     * @param user User object
     */
    public MainFrame(User user) {
        //this.mpanel = new MonthView();
        //this.wpanel = new WeekView();
        this.user = user;
        model = new Model(user);
        this.main = new MainPanel(model, user);
       
        JFrame frame = new JFrame();
        control = new CalController(main, model);
        //wpanel.setVisible(false);
        //mpanel.setVisible(true);
        //JPanel panel1 = new JPanel(true);
        control.setBorder(BorderFactory.createBevelBorder(1));
        //control.setPreferredSize(new Dimension(50, 50));
        
        
        //weekview panel = new weekview();
        
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
        //frame.add(panel2, BorderLayout.WEST);
        //main.add(mpanel, BorderLayout.CENTER);
        frame.add(main);
        //frame.add(wpanel, BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * changeWeek - Switch to week calendar (Deprecated)
     */
    public void changeWeek() {
        //calPanel = new WeekView();
        /*this.remove(mpanel);
        this.add(wpanel, BorderLayout.CENTER);
        this.repaint();*/
    }
    /**
     * changeMonth - change to month calendar (Deprecated)
     */
    public void changeMonth() {
        //this.remove(wpanel);
        //this.add(mpanel, BorderLayout.CENTER);
        this.repaint();
    }
    
    
    /**
     * actionPerformed
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        
    }
}
