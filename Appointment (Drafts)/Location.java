/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;

/**
 *
 * @author Sean
 */
public class Location {
    private String address;
    private String phoneNumber;
    private String latitude;
    private String longitude;
    
    public Location() {
        
    }
    
    public Location(String address) {
        this.address = address;
    }
    
    public Location(String lat, String lon) {
        this.latitude = lat;
        this.longitude = lon;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setLatLong(String lat, String lon) {
        this.latitude = lat;
        this.longitude = lon;
    }
    
    public String getLatLong() {
        String s = new String(latitude + " " + longitude);
        return s;
    }
}
