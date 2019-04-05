/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    Location Class - Defines Location object
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
public class Location {
    private String address;
    private String phoneNumber;
    private String latitude;
    private String longitude;
    
    /**
     * Default Constructor
     */
    public Location() {
        
    }
    
    /**
     * Parameterized Constructor
     * @param address  Sets location address
     */
    public Location(String address) {
        this.address = address;
    }
    /**
     * Parameterized Constructor, for lat long
     * @param lat latitude
     * @param lon longitude
     */
    public Location(String lat, String lon) {
        this.latitude = lat;
        this.longitude = lon;
    }
    /**
     * setAddress - sets address variable
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * getAddress - returns address for this Location
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * setPhoneNumber - sets a phone number for this Location
     * @param phoneNumber Phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * getPhoneNumber - returns the phone number
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /** 
     * setLatLong - sets latitude and longitude
     * @param lat latitude
     * @param lon longitude
     */
    public void setLatLong(String lat, String lon) {
        this.latitude = lat;
        this.longitude = lon;
    }
    /**
     * getLatLong - returns the lat and long for this Location
     * @return s, String of the lat and long
     */
    public String getLatLong() {
        String s = new String(latitude + " " + longitude);
        return s;
    }
}
