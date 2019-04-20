/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    UserDB class - Defines UserDB database object
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import timemanager.*;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class UserDB implements DataReadWrite {
    
    private String url;
    private Connection conn;
    /**
     * Default Constructor
     * @param url String location of database
     */
    public UserDB(String url) {
        this.url = url;
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
     * initialize - creates user table if it doesn't exist
     */
    public void initialize() {
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + " id integer PRIMARY KEY, \n"
                + " uname text NOT NULL, \n"
                + " password text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            //conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    /**
     * getData - returns User object from database
     * @param userName String username
     * @return User object
     */
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
                    //conn.close();
                }  
            }    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return user;
    }
    /**
     * setData - adds User object to database
     * @param user User object
     */
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
                //conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            }
        
    }
    /**
     * checkDuplicate - checks if user is a duplicate
     * @param userName String of username
     * @return boolean if user is matched
     */
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
    
    public ArrayList getAllUsers() {
        ArrayList<User> users = new ArrayList();
        
        String sql = "SELECT id, uname FROM user";
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User temp = new User();
                temp.setUserName(rs.getString("uname"));
                temp.setIdNumber(rs.getInt("id"));
                users.add(temp);
                 
            }    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
    
    
    
}
