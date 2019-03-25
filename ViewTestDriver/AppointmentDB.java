/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewwindowdriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class AppointmentDB implements DataReadWrite {
    private String url;
    private Connection conn;
    
    
    public AppointmentDB(String url) {
        
        this.url = url;
        
    }
    
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
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    }
    
    public ArrayList getData(String userName) {
        
        String sql = "SELECT id, username, apptname, startdate, enddate, reminder, location FROM Appointment "
                + "WHERE username LIKE '%" + userName + "%'";
        ArrayList<Appointment> appts = new ArrayList();
        try {Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);  
            while (rs.next()) {
               // System.out.println(rs.getString("username"));
               java.sql.Date sqlstartdate = rs.getDate("startdate");
               java.sql.Date sqlenddate = rs.getDate("enddate");
               java.util.Date startdate = new java.util.Date(sqlstartdate.getTime());
               java.util.Date enddate = new java.util.Date(sqlenddate.getTime());
               
               Appointment temp = new Appointment(rs.getString("apptname"));
               System.out.println(rs.getString("username"));
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
            conn.close();
                
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return appts;
        
    }
    
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
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
}
