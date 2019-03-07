/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserClass {
    private static Connection con;
    private static boolean hasData = false;
    public ResultSet displayUsers() throws SQLException{
        //System.out.println("displayUsers()");
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
                //System.out.println("Check: ResultSet res is true.");
            }
        }
    }
    public void addUser(String userName, String password){
        //System.out.println("addUsers()");
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
            PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?);");
            prep.setString(2, userName);
            prep.setString(3, password);
            prep.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
