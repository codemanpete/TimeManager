/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewwindowdriver;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Sean
 */
public class NewDayWindowPopUp extends JDialog {
    
       JLabel label;
        ArrayList<Appointment> appts;
    /**
     * Creates new form DayWindowPopUp
     */
    public NewDayWindowPopUp(java.awt.Frame parent, boolean modal, JLabel label, ArrayList appts) {
       
        super(parent, modal);
        this.appts = appts;
        this.label = label;
        initComponents();
    }
    
    public void initComponents() {
        
        JLabel dayLabel = new javax.swing.JLabel();

        
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        
        dayLabel = label;
        JPanel topPanel = new JPanel(true);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(dayLabel);
        //dayLabel.setAlignmentY(Component.LEFT_ALIGNMENT);
        
        add(topPanel);
        
        JLabel apptName;
        
        for (Appointment a : appts) {
            ApptPanel apanel = new ApptPanel(a);
            System.out.println("added");
            
            add(apanel);
            repaint();
        }
        
        pack();
    }
    
}
