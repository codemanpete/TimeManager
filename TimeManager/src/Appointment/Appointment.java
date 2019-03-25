/**
 * Appointment Class, for Time Manager class project
 * CS321-02
 * 
 */
package Appointment;
import java.util.*;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.YEAR;

/**
 *
 * @author Sean J Curtis
 * @version 0.2
 */
public class Appointment implements Comparable<Appointment> {

   
    private Calendar startTime;
    private Calendar endTime;
    private String apptName;
	private String userName;
	private int userID;
    private ArrayList<String> userList;
    private ArrayList<Asset> assetList;
    private Reminder reminder;
    private Location location;
    
    
     /**
     * Appointment Class constructor. 
     * @param name String for the Appointment title
     */
    public Appointment(String name) {
        apptName = new String(name);
        userList = new ArrayList<String>();
        assetList = new ArrayList<Asset>();
    }
    
     /**
     * setApptName - Sets Appointment object title
     * @param apptName name for the Appointment
     */
    public void setApptName(String apptName) {
        this.apptName = apptName;
    }
    
     /**
     * getApptName - Returns the name of the Appointment object
     * @return apptName String for Appointment name
     */
    public String getApptName() {
        return apptName;
    }
    
     /**
     * setStartTime - Sets appointment start time
     * @param year Sets Appointment year
     * @param month Sets Appointment month
     * @param day Sets Appointment day
     * @param hour Sets Appointment hour
     * @param min Sets Appointment min
     */
    public void setStartTime(int year, int month, int day, int hour, int min) {
        if (year < 2019)
            throw new DateOutOfRangeException("Year in the past");
        if (month > 11 || month < 0)
            throw new DateOutOfRangeException("Month out of range");
        if (month == 1 && day > 28)
            throw new DateOutOfRangeException("Feb only has 28 Days");
        if ((month == 3 || month == 5 || month == 8 || month == 10) && day > 30)
            throw new DateOutOfRangeException("Apr, Jun, Sep, and Nov only have 30 days");
        if ((month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 10 || month == 12) && day > 31)
            throw new DateOutOfRangeException("Jan, Mar, May, Jul, Aug, Oct, Dec only have 31 days");
        
        startTime = Calendar.getInstance();
        startTime.set(year, month, day, hour, min);
    }
    
     /**
     * getStartTime - Returns Date object for the Appointment starting time
     * @return startTime Date object
     */
    public Date getStartTime() {
       
        return startTime.getTime();
    }
    
      /**
     * setEndTime - Sets appointment start time
     * @param year Sets Appointment ending year
     * @param month Sets Appointment ending month
     * @param day Sets Appointment ending day
     * @param hour Sets Appointment ending hour
     * @param min Sets Appointment ending min
     */
    public void setEndTime(int year, int month, int day, int hour, int min) {
        if (year < 2019)
            throw new DateOutOfRangeException("Year in the past");
        if (month > 11 || month < 0)
            throw new DateOutOfRangeException("Month out of range");
        if (month == 1 && day > 28)
            throw new DateOutOfRangeException("Feb only has 28 Days");
        if ((month == 3 || month == 5 || month == 8 || month == 10) && day > 30)
            throw new DateOutOfRangeException("Apr, Jun, Sep, and Nov only have 30 days");
        if ((month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 10 || month == 12) && day > 31)
            throw new DateOutOfRangeException("Jan, Mar, May, Jul, Aug, Oct, Dec only have 31 days");
        if (month > 11 || month < 0)
            throw new DateOutOfRangeException("Month out of range");
        
        
        endTime = Calendar.getInstance();
        endTime.set(year, month, day, hour, min);
        if (endTime.compareTo(startTime) < 0)
            throw new DateOutOfRangeException("Appointment End is before Appointment Beginning");
    }
    
     /**
     * getEndTime - returns a Date object of the Appointment end time
     * @return endTime
     */
    public Date getEndTime() {
        return endTime.getTime();
    }
    
     /**
     * setReminder - Creates a reminder object for this Appointment
     * @param min integer of minutes to remind before startTime of Appointment object
     */
    public void setReminder(int min) {
        reminder = new Reminder(startTime.get(YEAR), 
                                startTime.get(MONTH), 
                                startTime.get(DAY_OF_MONTH), 
                                startTime.get(HOUR_OF_DAY), 
                                (startTime.get(MINUTE) - min), 
                                startTime.get(SECOND));
    }
    
     /**
     * checkReminder - checks this Appointments reminder and returns a boolean
     * value indicating if the remind time has passed or not
     * @return reminder.timeCheck boolean
     */
    public boolean checkReminder() {
      
        return reminder.timeCheck();
    }
    
     /**
     * compareTo - Implementation of Comparable class. This allows an 
     * ArrayList of Appointments to be sorted by the Collections.sort
     * 
     * @return integer value. -1 if this appointment is before other appointment
     * 1 if this appointment is after
     * 0 if they are the same
     */
   public int compareTo(Appointment other) {
       if (startTime.compareTo(other.startTime) < 0) return -1;
       if (startTime.compareTo(other.startTime) > 0) return 1;
       return 0;
   }
     
     /**
      * setLocation - Sets location object
      * @param address String of address for Appointment
      */
   public void setLocation(String address) {
       location = new Location();
       location.setAddress(address);
   }
     /**
      * getLocation - returns location for Appointment
      * @return String for address for Appointment
      */
   public String getLocation() {
       return location.getAddress();
   }
    
   /**
    * addUserToList - adds a user to this Appointments list of Users
    * @param username String of user to add
    */
   public void addUserToList(String username) {
       userList.add(username);
   }
   
   /**
    * getUserList - returns the list of users in this list
    * @return s cat string of users
    */
   public String getUserList() {
       String s = new String(" ");
       for (String user : userList) {
           s = s + " " + user;
       }
       return s;
   }
   
   /**
    * addAsset - Adds assets to the Appointment
    * @param a Asset
    */
   public void addAsset(Asset a) {
       assetList.add(a);
   }
   
   /**
    * getAssetList - retreves an asset
    * @return the first object in assetList array
    */
   public Asset getAssetList() {
       return assetList.get(0);
   }
   
   /**
    * setUserName - sets userName variable
    * @param userName
    */
   public void setUserName(String userName) {
	   this.userName = userName;
   }
   
   /**
    * getUserName - retreves userName
    * @return UserName variable
    */
   public String getUserName() {
	   return userName;
   }
   
   /**
    * setUserID - sets userID variable
    * @param userID
    */
   public void setUserID(int userID) {
	   this.userID = userID;
   }
   
   /**
    * getUserID - retreves UserID variable
    * @return userID variable
    */
   public int getUserID() {
	   return userID;
   }
    
    
}
