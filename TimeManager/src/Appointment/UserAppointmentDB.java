
/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    Appointment Class - Defines appointment object
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/

package Appointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sean
 */
public class UserAppointmentDB {
    private String url;
    
    
    public UserAppointmentDB(String url) {
        this.url = url;
    }
    
    
    
    
    public void initialize() {
        String sql = "CREATE TABLE IF NOT EXISTS user_Appointment (\n"
                + " id integer PRIMARY KEY, \n"
                + " user_id integer NOT NULL, \n"
                + " appointment_id integer NOT NULL, \n"
                + " FOREIGN KEY(user_id) REFERENCES user(id), \n"
                + " FOREIGN KEY(appointment_id) REFERENCES Appointment(id) \n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}



