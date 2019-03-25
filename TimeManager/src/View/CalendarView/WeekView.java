/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.CalendarView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;

/**
 *
 * @author Sean
 */
public class WeekView extends JPanel {
    private Calendar today = Calendar.getInstance();
    private String[] WEEKDAYS = {"Sunday", "Monday", "Tuesday", "Wednesday",
                             "Thursday", "Friday", "Saturday"};
    Model model;
    
        public WeekView(Model model) {
        this.model = model;
        this.add(makePanel());
    }
    
    public JPanel makePanel() {
        JPanel panel = new JPanel(true);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setSize(300, 300);
        panel.add(makeTopPanel(), BorderLayout.NORTH);
        panel.add(makeCalendarPanel(), BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel makeTopPanel() {
        JPanel panel = new JPanel(true);
        panel.setBorder(BorderFactory.createBevelBorder(1));
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.white);
        JLabel label = new JLabel(model.getMonthName() + " " + model.getYear());
        label.setForeground(Color.red);
        panel.add(label, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel makeCalendarPanel() {
        JPanel panel = new JPanel(true);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new GridLayout(0, 7));
        
        //int td = today.get(Calendar.DAY_OF_WEEK);
        int td = model.getWeekDayInt();
        
        for (int i = 0; i < 7; i++) {
            
            JLabel labels = new JLabel(model.getWeekDay(i));
            JPanel dayPanels = new JPanel(true);
            dayPanels.setBorder(BorderFactory.createLineBorder(Color.black));
            dayPanels.setPreferredSize(new Dimension(175, 600));
           // JLabel labels = new JLabel(WEEKDAYS[i-1]);
           
            if (i == td - 1) {
                labels.setForeground(Color.red);
            }
            
            dayPanels.add(labels, BorderLayout.NORTH);
            panel.add(dayPanels);
        }
        /*
        for (int i = 1; i < 8; i++) {
            JPanel panels = new JPanel(true);
            panels.setBorder(BorderFactory.createLineBorder(Color.black));
            panels.setPreferredSize(new Dimension(175, 500));
            JLabel labels = new JLabel(" " + i);
            panels.add(labels, BorderLayout.NORTH);
            panel.add(panels);
        }*/
        return panel;
    }
    
}
