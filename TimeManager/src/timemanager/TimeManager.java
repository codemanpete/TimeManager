package timemanager;

/*
    CS 321
    Team Project
    Time Manager/Scheduler
    Calendar
    Business Meetings
    
Members:
    Sean Curtis
    Peter Cheng
    Brendan Walker
 */


import User.UserClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TimeManager {

    public static void main(String[] args) {
        
        try {
            UserClass test = new UserClass();
            ResultSet rs;
            rs = test.displayUsers();
            while(rs.next()){
                System.out.println(rs.getString("uname")+" "+rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LoginFrame loginframe = new LoginFrame();
    }
    
}
