/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datareadwritedriver;
import java.sql.*;

/**
 *
 * @author Sean
 */
public class SQLReadWrite implements DataReadWrite {
    private String url;
    private Connection conn;
    
    public SQLReadWrite() {
        
    }
    
    public SQLReadWrite(String url) {
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
    
    private void makeTableUser() {
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + " id integer PRIMARY KEY, \n"
                + " name text NOT NULL, \n"
                + " password text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private void makeTableAppointment() {
        String sql = "CREATE TABLE IF NOT EXISTS Appointment (\n"
                + " id integer PRIMARY KEY, \n"
                + " username text NOT NULL, \n"
                + " apptname text NOT NULL, \n"
                + " startdate datetime NOT NULL, \n"
                + " enddate datetime NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void makeTables() {
        makeTableAppointment();
        makeTableUser();
    }
    
    public void insertData(User user) {
        String sql = "INSERT INTO user (name, password) VALUES(?,?)";
        //System.out.println(sql);
        try (Connection conn = this.connect(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassWord());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertData(Appointment appt) {
        String sql = "INSERT INTO Appointment (username, apptname, startdate, enddate) VALUES(?,?,?,?)";
        //System.out.println(sql);
        java.util.Date javaStartDate = appt.getStartTime();
        java.sql.Date sqlStartDate = new java.sql.Date(javaStartDate.getTime());
        
        java.util.Date javaEndDate = appt.getEndTime();
        java.sql.Date sqlEndDate = new java.sql.Date(javaEndDate.getTime());
        
        try (Connection conn = this.connect(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, appt.getApptName());
            pstmt.setString(2, appt.getUserName());
            pstmt.setDate(3, sqlStartDate);
            pstmt.setDate(4, sqlEndDate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private int searchName(String user) {
         String sql = "SELECT id, name FROM user";
         
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                
                if (user.compareTo(rs.getString("name")) == 0) {
                    int id = rs.getInt("id");
                    return id;
                }
                
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return -1;
    
    }
    
    private int searchAppointment(String apptname) {
         String sql = "SELECT id, apptname FROM Appointment";
         
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                
                if (apptname.compareTo(rs.getString("apptname")) == 0) {
                    int id = rs.getInt("id");
                    return id;
                }
                
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return -1;
    
    }
    
    public void removeUser(String user) {
        int userID = searchName(user);
        System.out.println(userID);
        
        String sql = "DELETE FROM user WHERE id = ?";
        
        try (Connection conn = this.connect(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void removeAppointment(String apptname) {
        int apptID = searchAppointment(apptname);
        System.out.println(apptID);
        
        String sql = "DELETE FROM Appointment WHERE id = ?";
        
        try (Connection conn = this.connect(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, apptID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public boolean checkPassword(String userName, String password) {
        int userID = searchName(userName);
        
        System.out.println(userID);
        
        String sql = "SELECT id, name, password FROM user WHERE id = " + userID;
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {    
                if (password.compareTo(rs.getString("password")) == 0) {
                    return true;
                } 
             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public ResultSet getUserAppointments(String userName) {
        String sql = "SELECT id, username, apptname, startdate, enddate FROM Appointment "
                + "WHERE username LIKE '%" + userName + "%'";
        
        try {Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);  
            //while (rs.next()) {
               // System.out.println(rs.getString("username"));
                
            //}
            return rs;
                
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
}
