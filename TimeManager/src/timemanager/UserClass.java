package timemanager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeRegExp.test;

public class UserClass {
    private static Connection con;
    private static boolean hasData = false;
    // Display Usernames and Passwords
    public ResultSet displayUsers() throws SQLException{
        // Check Connection
        if(con == null){
            try {
                getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT uname, password FROM user");
        return res;
    }
    // Get a Connection to the user.db SQLite Database
    private void getConnection() throws ClassNotFoundException, SQLException {
        // Please NOTE: This is absolutely CRITICAL
        // Must add sqlite-jdbc-(whatever version) to the library
        // Right Click the Libraries tab under the project tab to the left
        // Add .jar file
        System.out.println("getting connection...");
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:user.db");
        initialize();
    }
    // Create a database if there is none
    private void initialize() throws SQLException {
        System.out.println("initializing...");
        if(!hasData){
            hasData = true;
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' and name='user'");
            if(!res.next()){ 
                System.out.println("Check: Building Table");
                Statement state2 = con.createStatement();
                state2.execute("CREATE TABLE user(id integer, uname varchar(60), password varchar(60), primary key(id));");
                PreparedStatement prep = con.prepareStatement("INSERT INTO user values (?,?,?);");
                prep.setString(2,"Admin");
                prep.setString(3,"123");
                prep.execute();
                
                PreparedStatement prep2 = con.prepareStatement("INSERT INTO user values (?,?,?);");
                prep2.setString(2,"Brendan");
                prep2.setString(3,"123");
                prep2.execute();
            }
            else{
                // No action necessary
            }
        }
    }
    // Add a User with unique Username and Password
    public void addUser(String userName, String password){
        try {
            if(con==null){ // Establish a Connection to user.db
                try {
                    getConnection();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // Check if there is an existing user with Username, prevent duplicates
            String query = "SELECT * FROM user WHERE uname=?"; // query usernames
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, userName); // search for userName
            ResultSet rs = pst.executeQuery(); // execute search
            int count = 0;
            while(rs.next()){ // if userName is found
                count++; // increment count, should not be any duplicates
            }
            if(count == 1){
                JOptionPane.showMessageDialog(null,"Username Already Exists",
                "Error",JOptionPane.ERROR_MESSAGE); 
            }
            else{ // userName is not in user.db
                PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?);");
                prep.setString(2, userName);
                prep.setString(3, password);
                prep.execute();
                JOptionPane.showMessageDialog(null,"New User Created",
                "Try Logging In",JOptionPane.PLAIN_MESSAGE);
                // Display new list of Users and Passwords
                System.out.println("** Users and Passwords **");
                ResultSet rs1;
                rs1 = this.displayUsers();
                while(rs1.next()){
                    System.out.println(rs1.getString("uname")+" "+rs1.getString("password"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Verify User's username and password
    public boolean checkUserPW(String userName, String password){
        boolean result = false;
        try {
            if(con==null){
                try {
                    getConnection();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String query = "SELECT * FROM user WHERE uname=? and password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while(rs.next()){
                count++;
            }
            if(count == 1){
                result = true;
            }
            else{
                result = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }    
}
