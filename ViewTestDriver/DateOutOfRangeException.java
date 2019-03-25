/**
 * DateOutOfRangeException - for Appointment class
 * for Time Manager Class Project
 * for CS321-02
 */
package viewwindowdriver;
import java.io.Serializable;

/**
 *
 * @author Sean J Curtis
 */
public class DateOutOfRangeException extends RuntimeException implements Serializable {
    public DateOutOfRangeException() {
        
    }
    
    public DateOutOfRangeException(String msg) {
        super(msg);
    }
}
