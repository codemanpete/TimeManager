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
public interface DataReadWrite {
    
    
    public void insertData(User o);
    
    public void removeUser(String user);
    
    public ResultSet getUserAppointments(String userName);
    
}
