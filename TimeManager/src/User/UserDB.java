/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import timemanager.*;

/**
 *
 * @author Sean
 */
public class UserDB implements DataReadWrite {
    
    private String url;
    private Connection conn;
    
    public UserDB(String url) {
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
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + " id integer PRIMARY KEY, \n"
                + " uname text NOT NULL, \n"
                + " password text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public User getData(String userName) {
        String sql = "SELECT id, uname, password FROM user";
        User user = new User();
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                
                if (userName.compareTo(rs.getString("uname")) == 0) {
                    
                    user.setUserName(rs.getString("uname"));
                    user.setPassword(rs.getString("password"));
                    user.setIdNumber(Integer.parseInt(rs.getString("id"))); 
                    rs.close();
                    conn.close();
                }  
            }    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return user;
    }
    
    public void setData(User user) {
        if (!checkDuplicate(user.getUserName())){
             String sql = "INSERT INTO user (uname, password) VALUES(?,?)";
        //System.out.println(sql);
            try (Connection conn = this.connect(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, user.getUserName());
                pstmt.setString(2, user.getPassword());
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            }
        
    }
    
    private boolean checkDuplicate(String userName) {
        String sql = "SELECT uname FROM user";
        
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                
                if (userName.compareTo(rs.getString("uname")) == 0) {
                    
                    return true;
                }  
            }    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    
    
}
