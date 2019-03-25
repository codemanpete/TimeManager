/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datareadwritedriver;
import java.util.*;
import java.io.*;
import java.sql.*;
/**
 *
 * @author Sean
 */
public class DataReadWriteDriver {
    static String url = new String("jdbc:sqlite:test.db");
    static ArrayList<Appointment> appointments = new ArrayList<>();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File file = new File("test.db");
        
        if (file.exists()) {
            System.out.println("File Exists!");
            SQLReadWrite sql = new SQLReadWrite(url);
            sql.makeTables();
            User user = new User("Sean", "password");
            User user1 = new User("Dave", "password1");
            User user2 = new User("Bill", "password2");
            User user3 = new User("Jeff", "password3");
            Appointment appt = new Appointment("Sean", "test1");
            Appointment appt1 = new Appointment("Sean", "test2");
            Appointment appt2 = new Appointment("Sean", "test3");
            appt.setStartTime(2019, 3, 3, 3, 0);
            appt.setEndTime(2019, 3, 3, 4, 0);
            appt1.setStartTime(2019, 3, 3, 3, 0);
            appt1.setEndTime(2019, 3, 3, 4, 0);
            appt2.setStartTime(2019, 3, 3, 3, 0);
            appt2.setEndTime(2019, 3, 3, 4, 0);
            
            
           //sql.insertData(user);
           //sql.insertData(user1);
           //sql.insertData(user2);
           //sql.insertData(user3);
           //sql.insertData(appt);
           //sql.insertData(appt1);
           //sql.insertData(appt2);
           //sql.removeUser("Sean");
           //sql.removeAppointment("Sean");
           System.out.println(sql.checkPassword("Dave", "password1"));
           ResultSet rs = sql.getUserAppointments("Sean");
           
           try {
               while (rs.next()) {
                   java.sql.Date sqlstartdate = rs.getDate("startdate");
                   java.sql.Date sqlenddate = rs.getDate("enddate");
                   java.util.Date startdate = new java.util.Date(sqlstartdate.getTime());
                   java.util.Date enddate = new java.util.Date(sqlenddate.getTime());
                   System.out.println(startdate.getHours());
                   Appointment temp = new Appointment();
                   
                   temp.setApptName(rs.getString("apptname"));
                   temp.setUserName(rs.getString("username"));
                   
                   temp.setStartTime(startdate.getYear() + 1900, startdate.getMonth(), 
                                     startdate.getDate(), startdate.getHours(), startdate.getMinutes());
                   temp.setEndTime(enddate.getYear() + 1900, enddate.getMonth(), 
                                   enddate.getDate(), enddate.getHours() , enddate.getMinutes());
                   
                   appointments.add(temp);
                   
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           
           for (Appointment a : appointments) {
               System.out.println(a.getApptName() + " " +
                                  a.getStartTime().toString() + " " +
                                  a.getEndTime().toString());
           }
           
                
            
        }
        else {
            
        }
        
        
        
        
        
        
        
        
        
    }
    
}
