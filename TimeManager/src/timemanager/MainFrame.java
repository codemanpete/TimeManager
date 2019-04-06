/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    MainFrame class - creates main frame panel
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package timemanager;

import javax.swing.JFrame;

/**
 *
 * @author Brendan
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        super("Time Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,800);
        setVisible(true);
        setDefaultLookAndFeelDecorated(true);
        
        
    }
    
}
