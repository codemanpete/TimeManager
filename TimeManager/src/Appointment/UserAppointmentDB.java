
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sean and Peter
 */
public class UserAppointmentDB {
    private String url;
    
    
    public UserAppointmentDB(String url) {
        this.url = url;
    }
    
    /**
     * initializes cross reference table in db which is
     * responsible for maintaining relationship (many to 
     * many) between participants and appointments.
     * 
     */
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
    
    /**
     * connect - gets database connection
     * @return database connection object
     */
    private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    /**
     * setData - adds relational pair to db
     * @param userID the participant's id #
     * @param apptID the appointment's id #
     */
    public void setData(int userID, int apptID) {
        String sql = "INSERT INTO user_Appointment (user_id, appointment_id) VALUES(?,?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, String.valueOf(userID));
            pstmt.setString(2, String.valueOf(apptID));
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
        
    }


