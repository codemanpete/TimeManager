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
public class NewDayPanel extends JPanel{
    
    JLabel label;
        Model model;
        JFrame topFrame;
        ArrayList<Appointment> todaysAppts = new ArrayList();
        
        
        public NewDayPanel(JLabel label, Model model) {
        this.model = model;
        this.label = label;
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        getTodaysAppts(label);
        initComponents();
        //addApptPanels();
    }
        
    private void initComponents() {

        JLabel dayLabel = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        
        dayLabel = label;
        JPanel topPanel = new JPanel(true);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(dayLabel);
        //dayLabel.setAlignmentY(Component.LEFT_ALIGNMENT);
        
        add(topPanel);
        
        JLabel apptName;
        
        for (Appointment a : todaysAppts) {
            ApptPanel apanel = new ApptPanel(a);
            //System.out.println("added");
            
            add(apanel);
            repaint();
        }

        
		
    }                       

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
       // System.out.println(label.getText());
        NewDayWindowPopUp pop = new NewDayWindowPopUp(topFrame, true, label, todaysAppts);
        pop.setLocationRelativeTo(topFrame);
        pop.setVisible(true);
    }
    
    private void getTodaysAppts(JLabel label) {
       //System.out.println(label.getText());
        String today = label.getText();
        Integer td = Integer.parseInt(today.trim());
        ArrayList<Appointment> temp = model.getAppointments(td);
        
        for (Appointment t : temp) {
           
            Calendar day = t.getStartTime();
            
            if (t != null){
                if (day.get(Calendar.DATE) == td) {
                   //System.out.println(t.getApptName());
                    todaysAppts.add(t);
                }
            }
            
        }
        
    }
    
}
