/**
 * DateOutOfRangeException - for Appointment class
 * for Time Manager Class Project
 * for CS321-02
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
