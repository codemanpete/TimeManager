/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    DateOutOfRangeException
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package Appointment;

/**
 *
 * @author Sean J Curtis
 */
public class DateOutOfRangeException extends RuntimeException {
    public DateOutOfRangeException() {
        
    }
    
    public DateOutOfRangeException(String msg) {
        super(msg);
    }
}
