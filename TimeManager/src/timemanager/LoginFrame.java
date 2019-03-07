package timemanager;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
    JLabel label_login, label_username, label_password;
    JTextField textfield_username;
    JButton button_login, button_createUser;
    JPasswordField passwordfield;

    public LoginFrame() {
        // set the new window frame
        JFrame frame = new JFrame("Login Form");
        // create some objects
        label_login = new JLabel("Login Form");
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

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource()==button_login){
            String uname = textfield_username.getText();
            String pass = passwordfield.getText();
            UserClass test = new UserClass();
            boolean loginMatch = test.checkUserPW(uname,pass);
            if(loginMatch == true){
                MainFrame mainframe = new MainFrame();
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
            JOptionPane.showMessageDialog(this,"New User Created",
                "Try Logging In",JOptionPane.ERROR_MESSAGE);  
        }
    }
}