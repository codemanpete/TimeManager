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
public class MainPanel extends JPanel {
    //MonthView mpanel;
   // WeekView wpanel;
    JPanel calPanel;
    Model model;
    
    
    
    
    public MainPanel(Model model, User user) {
        //setPreferredSize(new Dimension(1500, 1500));
        setLayout(new CardLayout());
        this.model = model;
        
        this.calPanel = new MonthView(model);
        
       // this.mpanel = mpanel;
        //this.wpanel = wpanel;
        //add(wpanel);
        add(calPanel);
        
    }
    
    public void changeWeek() {
        removeAll();
        this.calPanel = new WeekView(model);
        add(calPanel);
        revalidate();
        repaint();
        
        
    }
    
    public void changeMonth() {
        removeAll();
        this.calPanel = new MonthView(model);
        add(calPanel);
        revalidate();
        repaint();
        
    }
    
    public void nextMonth() {
        
      removeAll();
      add(calPanel = new MonthView(model));
      revalidate();
      repaint();
    }
    
    
}
