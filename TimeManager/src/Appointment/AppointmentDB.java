/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    AppointmentDB Class - SQL driver for Appointment objects
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import timemanager.*;
/**
 *
 * @author Sean J Curtis
 */
public class AppointmentDB implements DataReadWrite {
//public class AppointmentDB  {
    private String url;
    private Connection conn;
    private ArrayList<Appointment> appointments;
    
    /**
     * Constructor
     * @param url String for the SQL DB url 
     */
    public AppointmentDB(String url) {
        
        this.url = url;
        
    }
    /**
     * connect - creates a connection to the sqlite database
     * @return Connection object
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
     * initialize - creates the Appointment table in the sqlite database
     */
    public void initialize() {
        String sql = "CREATE TABLE IF NOT EXISTS Appointment (\n"
                + " id integer PRIMARY KEY, \n"
                + " username text NOT NULL, \n"
                + " userid integer NOT NULL, \n"
                + " apptname text NOT NULL, \n"
                + " startdate datetime NOT NULL, \n"
                + " enddate datetime NOT NULL, \n"
                + " reminder integer NOT NULL, \n"
                + " location text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    /**
     * setData - adds an appointment field to the database
     * @param appt Appointment object
     */
    public void setData(Appointment appt) {
        
        if (!checkDuplicates(appt.getUserName(), appt.getApptName())) {
        String sql = "INSERT INTO Appointment (username, userid, apptname, startdate, enddate, reminder, location) VALUES(?,?,?,?,?,?,?)";
        //System.out.println(sql);
        
        java.util.Date javaStartDate = appt.getStartTime().getTime();
        java.sql.Date sqlStartDate = new java.sql.Date(javaStartDate.getTime());
        
        java.util.Date javaEndDate = appt.getEndTime().getTime();
        java.sql.Date sqlEndDate = new java.sql.Date(javaEndDate.getTime());
        
        try (Connection conn = this.connect(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, appt.getUserName());
                pstmt.setInt(2, appt.getuserID());
                pstmt.setString(3, appt.getApptName());
                pstmt.setDate(4, sqlStartDate);
                pstmt.setDate(5, sqlEndDate);
                pstmt.setInt(6, appt.getReminder());
                pstmt.setString(7, appt.getLocation());
                pstmt.executeUpdate();
                pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    }
    /**
     * getData - reads database and creates arraylist of appointment objects
     * @param userName User to search for
     * @return ArrayList of Appointment objects
     */
    public ArrayList getData(String userName) {
        
        String sql = "SELECT id, username, apptname, startdate, enddate, reminder, location FROM Appointment "
                + "WHERE username LIKE '%" + userName + "%'";
        ArrayList<Appointment> appts = new ArrayList();
        try {Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);  
            while (rs.next()) {
               java.sql.Date sqlstartdate = rs.getDate("startdate");
               java.sql.Date sqlenddate = rs.getDate("enddate");
               java.util.Date startdate = new java.util.Date(sqlstartdate.getTime());
               java.util.Date enddate = new java.util.Date(sqlenddate.getTime());
               
               Appointment temp = new Appointment(rs.getString("apptname"));
              // System.out.println(rs.getString("username"));
               temp.setUserName(rs.getString("username"));
               temp.setApptName(rs.getString("apptname"));
               temp.setLocation(rs.getString("location"));
               
               
               temp.setStartTime(startdate.getYear() + 1900, startdate.getMonth(), 
                                     startdate.getDate(), startdate.getHours(), startdate.getMinutes());
               temp.setEndTime(enddate.getYear() + 1900, enddate.getMonth(), 
                                   enddate.getDate(), enddate.getHours() , enddate.getMinutes());
               temp.setReminder(rs.getInt("reminder"));
                   
               appts.add(temp);
                
            }
            rs.close();           
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return appts;
        
    }
    /**
     * checkDuplicates - checks database for duplicate entries
     * @param apptname - appointment name
     * @param userName - username
     * @return true or false
     */
    private boolean checkDuplicates(String apptname, String userName) {
        String sql = "SELECT username, apptname FROM Appointment";
        
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                
                if ((userName.compareTo(rs.getString("username")) == 0) && (apptname.compareTo(rs.getString("apptname"))) == 0) {
                    
                    return true;
                }  
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    private void seperate(Appointment appt) {
        appointments = new ArrayList<Appointment>();
        Calendar start = appt.getStartTime();
        Calendar end = appt.getEndTime();
        for (int i = appt.getStartDay(); i <= appt.getEndDay(); i++) {
            Appointment temp = new Appointment(appt.getApptName());
            temp.setStartTime(start.get(Calendar.YEAR), 
                              start.get(Calendar.MONTH),
                              i,
                              start.get(Calendar.HOUR),
                              start.get(Calendar.MINUTE));
            temp.setEndTime(end.get(Calendar.YEAR),
                            end.get(Calendar.MONTH),
                            i,
                            end.get(Calendar.HOUR),
                            end.get(Calendar.MINUTE));
            appointments.add(temp);
        }
    }
    
    public void delAppt(Appointment appt){
        try (Connection conn = this.connect()) {
            System.out.println("Delete this appointment: "+appt.getApptName());
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
