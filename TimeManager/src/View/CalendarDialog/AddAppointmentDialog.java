/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    AddAppointmentDialog class - Creates add appointment dialog box
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package View.CalendarDialog;

import java.awt.Frame;
import javax.swing.JFrame;
import Appointment.*;
import User.*;
import View.CalendarView.MainPanel;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import 

/**
 *
 * @author Sean
 */
public class AddAppointmentDialog extends javax.swing.JDialog {

    Appointment appt;
        String apptLocation;
        int apptStartYear = 2019;
        int apptEndYear = 2019;
        int apptStartMonth = 0;
        int apptEndMonth = 1;
        int apptStartDay = 1;
        int apptEndDay = 1;
        int apptStartHour = 00;
        int apptEndHour = 00;
        int apptStartMin = 00;
        int apptEndMin = 00;
        int apptReminder = 00;
        User user;
        Frame frame;
        MainPanel main;
        int curDay;
        int curMonth;

    /**
     * Creates new form AddAppointmentDialog
     */
    public AddAppointmentDialog(java.awt.Frame parent, boolean modal, User user, MainPanel main) {
        super(parent, modal);
        this.user = user;
        this.frame = parent;
        this.main = main;
        initComponents();
    }
    
    public AddAppointmentDialog(java.awt.Frame parent, boolean modal, User user, MainPanel main, int curMonth, int curDay) {
        super(parent, modal);
        this.user = user;
        this.frame = parent;
        this.main = main;
        this.curMonth = curMonth;
        this.curDay = curDay;
        this.apptStartDay = curDay;
        this.apptEndDay = curDay;
        this.apptStartMonth = curMonth;
        this.apptEndMonth = curMonth;
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        locationBox = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        startMonth = new javax.swing.JComboBox<>();
        startYear = new javax.swing.JComboBox<>();
        startDay = new javax.swing.JComboBox<>();
        startHour = new javax.swing.JComboBox<>();
        startMin = new javax.swing.JComboBox<>();
        endMonth = new javax.swing.JComboBox<>();
        endYear = new javax.swing.JComboBox<>();
        endDay = new javax.swing.JComboBox<>();
        endHour = new javax.swing.JComboBox<>();
        endMinute = new javax.swing.JComboBox<>();
        reminderMenu = new javax.swing.JComboBox<>();
        ParticipantList = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Add Appointment");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));
        getContentPane().add(nameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 29, 210, -1));

        jLabel2.setText("Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 32, -1, -1));

        jLabel3.setText("Year");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 64, -1, -1));

        jLabel4.setText("Month");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 64, -1, -1));

        jLabel5.setText("Day");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 64, -1, -1));

        jLabel6.setText("Hour");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 64, -1, -1));

        jLabel7.setText("Minute");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 64, -1, -1));

        jLabel8.setText("Start Time:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 96, -1, -1));

        jLabel9.setText("End Time:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 134, -1, -1));

        jLabel10.setText("Location:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 184, -1, -1));
        getContentPane().add(locationBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 187, 230, 20));

        jLabel11.setText("Reminder:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 228, -1, -1));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        startMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        startMonth.setSelectedIndex(curMonth);
        startMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMonthActionPerformed(evt);
            }
        });
        getContentPane().add(startMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 93, -1, -1));

        startYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022" }));
        startYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startYearActionPerformed(evt);
            }
        });
        getContentPane().add(startYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 93, -1, -1));

        startDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        startDay.setSelectedIndex(curDay - 1);
        startDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDayActionPerformed(evt);
            }
        });
        getContentPane().add(startDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 93, -1, -1));

        startHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        startHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startHourActionPerformed(evt);
            }
        });
        getContentPane().add(startHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 93, -1, -1));

        startMin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        startMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMinActionPerformed(evt);
            }
        });
        getContentPane().add(startMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 93, -1, -1));

        endMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        endMonth.setSelectedIndex(curMonth);
        endMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endMonthActionPerformed(evt);
            }
        });
        getContentPane().add(endMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 134, -1, -1));

        endYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022" }));
        endYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endYearActionPerformed(evt);
            }
        });
        getContentPane().add(endYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 134, -1, -1));

        endDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        endDay.setSelectedIndex(curDay - 1);
        endDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDayActionPerformed(evt);
            }
        });
        getContentPane().add(endDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 134, -1, -1));

        endHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        endHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endHourActionPerformed(evt);
            }
        });
        getContentPane().add(endHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 134, -1, -1));

        endMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        endMinute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endMinuteActionPerformed(evt);
            }
        });
        getContentPane().add(endMinute, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 134, -1, -1));

        reminderMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "15", "20", "25", "30", "45", "60" }));
        reminderMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminderMenuActionPerformed(evt);
            }
        });
        getContentPane().add(reminderMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 225, -1, -1));

        ParticipantList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParticipantListActionPerformed(evt);
            }
        });
        getContentPane().add(ParticipantList, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 270, -1));

        jLabel12.setText("Participants:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * jButton1ActionPerformed - event handler for button1
 * @param evt 
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // split participant string by spaces
        String[] splitStr = ParticipantList.getText().trim().split("\\s+");
        for (int i = 0; i<splitStr.length; ++i) {
            System.out.println(splitStr[i]);
        }
        
        Appointment appt = new Appointment(nameBox.getText(), user.getIdNumber());
        appt.setUserName(user.getUserName());
        appt.setStartTime(apptStartYear, apptStartMonth, apptStartDay, apptStartHour, apptStartMin);
        appt.setEndTime(apptEndYear, apptEndMonth, apptEndDay, apptEndHour, apptEndMin);
        appt.setLocation(locationBox.getText());
        appt.setReminder(apptReminder);
        
        //user.addAppointment(appt);
        
        AppointmentDB apptDB = new AppointmentDB("jdbc:sqlite:user.db");
        if (apptDB.setData(appt)) 
        {
          /*
           InfoDialog diag = new InfoDialog(frame, true, "Appointment Added");
           diag.setLocationRelativeTo(frame);
           diag.setVisible(true);
           */
            
           JOptionPane.showMessageDialog(this,"Appointment Added!",
                "Success",JOptionPane.INFORMATION_MESSAGE); 
            
           user.setAppointments();
           main.paintComponent();
           dispose(); 
        }
        else {
            /*
            InfoDialog diag = new InfoDialog(frame, true, "Duplicate Appointment Exists");
            diag.setLocationRelativeTo(frame);
            diag.setVisible(true);
            */
            
            JOptionPane.showMessageDialog(this,"Duplicate Appointment Exists!",
                "Error",JOptionPane.ERROR_MESSAGE); 
        }
        
        //
        
            
            
            
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * jButton2ActionPerformed - event handler for button2
 * @param evt 
 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
/**
 * startYearActionPerformed - sets Start Year
 * @param evt 
 */
    private void startYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startYearActionPerformed
                // TODO add your handling code here:
        String s = new String();
        s = (String) startYear.getSelectedItem();
        this.apptStartYear = Integer.parseInt(s);
        //System.out.println(apptStartYear);
    }//GEN-LAST:event_startYearActionPerformed
/**
 * startMonthActionPerformed - sets start month
 * @param evt 
 */
    private void startMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMonthActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) startMonth.getSelectedItem();
        if (s.compareTo("Jan") == 0) {
            this.apptStartMonth = 0;
        }
        else if (s.compareTo("Feb") == 0) {
            this.apptStartMonth = 1;
        }
        else if (s.compareTo("Mar") == 0) {
            this.apptStartMonth = 2;
        }
        else if (s.compareTo("Apr") == 0) {
            this.apptStartMonth = 3;
        }
        else if (s.compareTo("May") == 0) {
            this.apptStartMonth = 4;
        }
        else if (s.compareTo("Jun") == 0) {
            this.apptStartMonth = 5;
        }
        else if (s.compareTo("Jul") == 0) {
            this.apptStartMonth = 6;
        }
        else if (s.compareTo("Aug") == 0) {
            this.apptStartMonth = 7;
        }
        else if (s.compareTo("Sep") == 0) {
            this.apptStartMonth = 8;
        }
        else if (s.compareTo("Oct") == 0) {
            this.apptStartMonth = 9;
        }
        else if (s.compareTo("Nov") == 0) {
            this.apptStartMonth = 10;
        }
        else if (s.compareTo("Dec") == 0) {
            this.apptStartMonth = 11;
        }
        
       // System.out.println(" " + apptStartMonth);
        
    }//GEN-LAST:event_startMonthActionPerformed
/**
 * startDayActionPerformed - sets start day
 * @param evt 
 */
    private void startDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDayActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) startDay.getSelectedItem();
        this.apptStartDay = Integer.parseInt(s);
    }//GEN-LAST:event_startDayActionPerformed
/**
 * startHourActionPerformed - sets start hour
 * @param evt 
 */
    private void startHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startHourActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) startHour.getSelectedItem();
        this.apptStartHour = Integer.parseInt(s);
    }//GEN-LAST:event_startHourActionPerformed
/**
 * startMinActionPerformed - sets start min
 * @param evt 
 */
    private void startMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMinActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) startMin.getSelectedItem();
        this.apptStartMin = Integer.parseInt(s);
    }//GEN-LAST:event_startMinActionPerformed
/**
 * endYearActionPerformed - sets end year
 * @param evt 
 */
    private void endYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endYearActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) endYear.getSelectedItem();
        this.apptEndYear = Integer.parseInt(s);
    }//GEN-LAST:event_endYearActionPerformed
/**
 * endMonthActionPerformed - sets end month
 * @param evt 
 */
    private void endMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endMonthActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) endMonth.getSelectedItem();
        if (s.compareTo("Jan") == 0) {
            this.apptEndMonth = 0;
        }
        else if (s.compareTo("Feb") == 0) {
            this.apptEndMonth = 1;
        }
        else if (s.compareTo("Mar") == 0) {
            this.apptEndMonth = 2;
        }
        else if (s.compareTo("Apr") == 0) {
            this.apptEndMonth = 3;
        }
        else if (s.compareTo("May") == 0) {
            this.apptEndMonth = 4;
        }
        else if (s.compareTo("Jun") == 0) {
            this.apptEndMonth = 5;
        }
        else if (s.compareTo("Jul") == 0) {
            this.apptEndMonth = 6;
        }
        else if (s.compareTo("Aug") == 0) {
            this.apptEndMonth = 7;
        }
        else if (s.compareTo("Sep") == 0) {
            this.apptEndMonth = 8;
        }
        else if (s.compareTo("Oct") == 0) {
            this.apptEndMonth = 9;
        }
        else if (s.compareTo("Nov") == 0) {
            this.apptEndMonth = 10;
        }
        else if (s.compareTo("Dec") == 0) {
            this.apptEndMonth = 11;
        }
    }//GEN-LAST:event_endMonthActionPerformed
/**
 * endDayActionPerformed - sets end day
 * @param evt 
 */
    private void endDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDayActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) endDay.getSelectedItem();
        this.apptEndDay = Integer.parseInt(s);
    }//GEN-LAST:event_endDayActionPerformed
/**
 * endHourActionPerformed - sets end Hour
 * @param evt 
 */
    private void endHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endHourActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) endHour.getSelectedItem();
        this.apptEndHour = Integer.parseInt(s);
    }//GEN-LAST:event_endHourActionPerformed
/**
 * endMinuteActionPerformed - sets end min
 * @param evt 
 */
    private void endMinuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endMinuteActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) endMinute.getSelectedItem();
        this.apptEndMin = Integer.parseInt(s);
    }//GEN-LAST:event_endMinuteActionPerformed
/**
 * reminderMenuActionPerformed - sets remind time
 * @param evt 
 */
    private void reminderMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminderMenuActionPerformed
        // TODO add your handling code here:
        String s = new String();
        s = (String) reminderMenu.getSelectedItem();
        this.apptReminder = Integer.parseInt(s);
    }//GEN-LAST:event_reminderMenuActionPerformed

    private void ParticipantListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParticipantListActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ParticipantListActionPerformed

    /**
     * @param args the command line arguments
     */
    
    /*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddAppointmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAppointmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAppointmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAppointmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddAppointmentDialog dialog = new AddAppointmentDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ParticipantList;
    private javax.swing.JComboBox<String> endDay;
    private javax.swing.JComboBox<String> endHour;
    private javax.swing.JComboBox<String> endMinute;
    private javax.swing.JComboBox<String> endMonth;
    private javax.swing.JComboBox<String> endYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField locationBox;
    private javax.swing.JTextField nameBox;
    private javax.swing.JComboBox<String> reminderMenu;
    private javax.swing.JComboBox<String> startDay;
    private javax.swing.JComboBox<String> startHour;
    private javax.swing.JComboBox<String> startMin;
    private javax.swing.JComboBox<String> startMonth;
    private javax.swing.JComboBox<String> startYear;
    // End of variables declaration//GEN-END:variables
}
