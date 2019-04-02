/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Controller;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import View.CalendarView.*;

/**
 *
 * @author Sean
 */
public class CalController extends JPanel {
    private MainPanel panel;
    private Model model;
    boolean monthOrWeek;
    private JButton monthSwitch;
    private JButton prevMonth;
    private JButton nextMonth;
    
    
    public CalController(MainPanel panel, Model model) {
        this.panel = panel;
        this.model = model;
        monthOrWeek = true;
        //JPanel controller = new JPanel(true);
        //this.setLayout(new GridLayout(2, 2));
        //this.setLayout(new FlowLayout);
        this.setLayout(new BorderLayout());
        
        
        
        
        
        nextMonth = new JButton();
        nextMonth.setText("Next");
        nextMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int next = model.getMonth();
                next++;
                model.setMonth(next);
                panel.nextMonth();
            }
        });
        
        
        prevMonth = new JButton();
        prevMonth.setText("Prev");
        prevMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prev = model.getMonth();
                prev--;
                model.setMonth(prev);
                panel.nextMonth();
            }
        });
        buttonInit();
        //add(prevMonth);
        //add(weekSwitch);
        //add(monthSwitch);
        //add(nextMonth);
        
        
        setVisible(true);
        
        
        
    }
    
    
    
    private void buttonInit() {
        //remove(monthSwitch);
        if (monthOrWeek) {
        monthSwitch = new JButton();    
        monthSwitch.setText("Week");
        monthSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.changeWeek();
                monthOrWeek = false;
                buttonInit();
                
            }
        });
        }
        else {
        monthSwitch = new JButton();
        monthSwitch.setText("Month");
        monthSwitch.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.changeMonth();
                monthOrWeek = true;
                buttonInit();
                
            }
        });
        }
        removeAll();
        add(prevMonth, BorderLayout.WEST);
        add(monthSwitch, BorderLayout.CENTER);
        add(nextMonth, BorderLayout.EAST);
        revalidate();
        repaint();
      
    }
    
}
