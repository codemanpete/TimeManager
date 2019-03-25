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
public class MonthView extends JPanel {
    
   private Calendar today = Calendar.getInstance();
   int month;
   Model model;
  
   
   
    
    public MonthView(Model model) {
        month = today.get(Calendar.MONTH);
        this.model = model;
        
        this.add(makePanel());
    }
    
    public MonthView(int month) {
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
        
       // String[] MONTHNAMES = { "January", "February", "March", "April", 
       //                        "May", "June", "July", "August",
       //                        "September", "October", "November", "December" };
        //today = Calendar.getInstance();
        today.set(Calendar.MONTH, (month));
        JPanel panel = new JPanel(true);
        panel.setBorder(BorderFactory.createBevelBorder(1));
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.white);
        //JLabel label = new JLabel(MONTHNAMES[month]);
        JLabel label = new JLabel(model.getMonthName() + " " + model.getYear());
        label.setForeground(Color.red);
        panel.add(label, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel makeCalendarPanel() {
        JPanel panel = new JPanel(true);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new GridLayout(0, 7));
       // today = Calendar.getInstance();
        //Calendar firstDay = Calendar.getInstance();
        //firstDay = today;
        //firstDay.set(Calendar.DAY_OF_MONTH, (today.get(Calendar.DAY_OF_MONTH)-(Calendar.DAY_OF_MONTH - 1)));
       // firstDay.set(Calendar.DAY_OF_MONTH, 1);
        
        //int td = today.get(Calendar.DAY_OF_MONTH);
        int td = model.getToday();
        
        //System.out.println(td);
      
        
        //String[] WEEKDAYS = {"Sunday", "Monday", "Tuesday", "Wednesday",
         //                    "Thursday", "Friday", "Saturday"};
        
        //System.out.println(WEEKDAYS[firstDay.get(Calendar.DAY_OF_WEEK)]);
        //System.out.println(WEEKDAYS[firstDay.get(Calendar.DAY_OF_WEEK) - 1]);
        //System.out.println(today.get(Calendar.DAY_OF_WEEK));
       
        for (int i = 0; i < 7; i++) {
            JPanel panels = new JPanel(true);
            panels.setBorder(BorderFactory.createLineBorder(Color.black));
            //JLabel labels = new JLabel(WEEKDAYS[i]);
            JLabel labels = new JLabel(model.getWeekDay(i));
            panels.setPreferredSize(new Dimension(175, 50));
            
            
            panels.add(labels, BorderLayout.NORTH);
            panel.add(panels);
        }
        
        //int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        
        //for (int i = 1; i <= (DAYS_IN_MONTH[today.get(Calendar.MONTH)] + firstDay.get(Calendar.DAY_OF_WEEK) - 1); i++) {
        for (int i = 1; i <= (model.getDaysInMonth() + model.getFirstDay() - 1); i++) {
            
            
            
            //if (i < (firstDay.get(Calendar.DAY_OF_WEEK )  )) {
            if (i < (model.getFirstDay()  )) {
                JPanel panels = new JPanel(true);
                panels.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(panels);
            }
            
            else {
           //String startday = new String()
            
            
            //JLabel labels = new JLabel(" " +(i - (firstDay.get(Calendar.DAY_OF_WEEK) - 1)));
            JLabel labels = new JLabel((i - (model.getFirstDay() - 1))+ " ");
            labels.setAlignmentY(Component.LEFT_ALIGNMENT);
            
            //if ((i - (firstDay.get(Calendar.DAY_OF_WEEK) - 1)) == td) {
            if ((i - (model.getFirstDay() - 1)) == td) {
                labels.setForeground(Color.red);
            }
            
            NewDayPanel panels = new NewDayPanel(labels, model);
            panels.setBorder(BorderFactory.createLineBorder(Color.black));
            panels.setPreferredSize(new Dimension(175, 125));
            //panels.add(labels, BorderLayout.NORTH);
            panel.add(panels);
            }
        }
        return panel;
    }
    
    public int getMonth() {
        return month;
    }
    
    public void addMonth() {
        int td = today.get(Calendar.MONTH);
        td++;
        today.set(Calendar.MONTH, td);
        System.out.println(today.get(Calendar.MONTH));
        
       
    }
}
