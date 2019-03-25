/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.CalendarPanel;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Sean
 */
public class ApptPanel extends JPanel{
    private Appointment appt;
    
    public ApptPanel(Appointment appt) {
        this.appt = appt;
        this.add(makePanel());
    }
    
    
    private JPanel makePanel() {
        JPanel panel = new JPanel(true);
        panel.setLayout(new FlowLayout());
        //panel.setPreferredSize(new Dimension(10, 10));
        JLabel apptName = new JLabel(appt.getApptName());
        JLabel startTime  = new JLabel((appt.getStartTime().get(Calendar.HOUR_OF_DAY)) + 
                                        ":" + (appt.getStartTime().get(Calendar.MINUTE) + "0"));
        
       
        
        JLabel stopTime  = new JLabel((appt.getEndTime().get(Calendar.HOUR_OF_DAY)) + 
                                        ":" + (appt.getEndTime().get(Calendar.MINUTE) + "0"));
        panel.add(apptName);
        panel.add(startTime);
        
        panel.add(stopTime);
        return panel;
    }
    
    
}
