/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    n
*    Asset Class - Defines Asset object
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
public class Asset {
    
    private String name;
    private boolean inUse;
    
    /**
     * Asset default constructor
     * @param name String sets Asset name
     */
    public Asset(String name) {
        this.name = name;
        inUse = false;
    }
    /**
     * getName() - returns the name of the Asset
     * @return name String asset name
     */
    public String getName() {
        return name;
    }
    
    
    /**
     * getInUse() - returns boolean indicating if Asset is in use
     *
     * @return inUse boolean Asset usage tag
     */
    public boolean getInUse() {
        return inUse;
    }
    
    /**
     * setUse - sets usage flag for Asset
     * @param inUse - sets usage flag
     */
    public void setUse(boolean inUse) {
        this.inUse = inUse;
    }
}
