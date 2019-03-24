/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewwindowdriver;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Sean
 */
public class ViewWindowDriver extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user = new User("Sean", "password");
        String url = new String("jdbc:sqlite:timemanager.db");
        //UserDB udb = new UserDB(url);
       AppointmentDB apptdb = new AppointmentDB(url);
       // apptdb.initialize();
        //udb.initialize();
        
        //udb.setData(user);
        
        //User user2 = udb.getData("Sean");
        
        //System.out.println(user2.getUserName());
        
        
        
        Appointment appt = new Appointment("test");
        appt.setStartTime(2019, 2, 19, 14, 00);
        appt.setEndTime(2019, 2, 19, 15, 00);
        appt.setReminder(10);
        appt.setUserName("Sean");
        //Location loc = new Location("test");
        appt.setLocation("test");
        appt.setuserID(5);
        //apptdb.setData(appt);
        Appointment appt1 = new Appointment("test2");
        appt1.setStartTime(2019, 2, 19, 16, 00);
        appt1.setEndTime(2019, 2, 19, 17, 00);
        appt1.setReminder(10);
        appt1.setUserName("Sean");
        //Location loc = new Location("test");
        appt1.setLocation("test");
        appt1.setuserID(5);
       // apptdb.setData(appt1);
        
        //user.addAppointment(appt);
       // user.addAppointment(appt1);
        MainFrame frame = new MainFrame(user);
        
        
        //CalController control = new CalController(frame);
        
        
    }
    
}
