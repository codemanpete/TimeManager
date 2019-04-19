/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    LoginFrame class - creates login panel
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package timemanager;

import User.UserClass;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * 
 * @author Brendan Walker
 */
public class LoginFrame extends JFrame implements ActionListener {
    JLabel label_login, label_username, label_password;
    JTextField textfield_username;
    JButton button_login, button_createUser;
    JPasswordField passwordfield;
    JFrame frame;
/**
 * Default Constructor
 */
    public LoginFrame() {
        // set the new window frame
        frame = new JFrame("Time Manager Login");
        // create some objects
        label_login = new JLabel("Time Manager");
        label_login.setForeground(Color.blue);
        label_login.setFont(new Font("Serif", Font.BOLD, 20));
        label_username = new JLabel("Username");
        label_password = new JLabel("Password");
        textfield_username = new JTextField();
        passwordfield = new JPasswordField();
        // establish sizes and locations
        label_login.setBounds(100, 30, 400, 30);
        label_username.setBounds(80, 70, 200, 30);
        label_password.setBounds(80, 110, 200, 30);
        textfield_username.setBounds(300, 70, 200, 30);
        passwordfield.setBounds(300, 110, 200, 30);
        // add objects to frame
        frame.add(label_login);
        frame.add(label_username);
        frame.add(textfield_username);
        frame.add(label_password);
        frame.add(passwordfield);
        // Add login button
        button_login = new JButton("Login");
        button_login.setBounds(150, 160, 100, 30);
        button_login.addActionListener(this);
        frame.add(button_login);
        // Add login button
        button_createUser = new JButton("Create New");
        button_createUser.setBounds(350, 160, 100, 30);
        button_createUser.addActionListener(this);
        frame.add(button_createUser);
        frame.setSize(600, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
/**
 * actionPerformed - for buttons
 * @param e 
 */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource()==button_login){
            String uname = textfield_username.getText();
            String pass = passwordfield.getText();
            UserClass test = new UserClass();
            boolean loginMatch = test.checkUserPW(uname,pass);
            if(loginMatch == true){
               // MainFrame mainframe = new MainFrame();
                //User.User mainuser = new User.User(uname, pass);
                User.User mainuser;
                User.UserDB db = new User.UserDB("jdbc:sqlite:user.db");
                mainuser = db.getData(uname);
                mainuser.setAppointments();
                
                frame.dispose();
                View.CalendarView.MainFrame frame = new View.CalendarView.MainFrame(mainuser);
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Incorrect login or password",
                "Error",JOptionPane.ERROR_MESSAGE); 
            }
        }
        else if(e.getSource()==button_createUser){
            String uname = textfield_username.getText();
            String pass = passwordfield.getText();
            UserClass test = new UserClass();
            test.addUser(uname,pass);  
        }
    }
}