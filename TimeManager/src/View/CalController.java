/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewwindowdriver;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Sean
 */
public class CalController extends JPanel {
    private MainPanel panel;
    private Model model;
    
    public CalController(MainPanel panel, Model model) {
        this.panel = panel;
        this.model = model;
        //JPanel controller = new JPanel(true);
        this.setLayout(new GridLayout(2, 2));
        //this.setLayout(new BorderLayout());
        JButton weekSwitch = new JButton();
        weekSwitch.setText("Week");
        weekSwitch.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.changeWeek();
            }
        });
        
        JButton monthSwitch = new JButton();
        monthSwitch.setText("Month");
        monthSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.changeMonth();
            }
        });
        
        JButton nextMonth = new JButton();
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
        
        JButton prevMonth = new JButton();
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
        
        add(weekSwitch);
        add(monthSwitch);
        add(prevMonth);
        add(nextMonth);
        
        
        setVisible(true);
        
        
        
    }
    
}
