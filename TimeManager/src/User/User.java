/**
*    CS 321
*    Team Project
*    Time Manager/Scheduler
*    Calendar
*    Business Meetings
*    
*    User Class- Defines User object
*    
*Members:
*    Sean Curtis
*    Peter Cheng
*    Brendan Walker
*    Charles McEniry
*/
package User;
import java.util.ArrayList;
import Appointment.*;
import java.util.Collections;

/**
 *
 * @author petercheng
 * 
 */
public class User {
   private String firstName;
   private String lastName;
   private String userName;
   //private Password password;
   private String password;
   private int idNumber;
   private boolean status;
   private ArrayList<String> contactList;
   private ArrayList<Appointment> apptList;
   private String phoneNumber;
   private String address;
   private ArrayList<String> groupMembership;

/**
 * Default Constructor
 */
public User() {
       firstName = new String();
       lastName = new String();
       userName = new String();
       //password = new Password("Default");
       idNumber = 0;
       status = false;
       contactList = new ArrayList<String>();
       apptList = new ArrayList<Appointment>();
       phoneNumber = new String();
       address = new String();
       groupMembership = new ArrayList<String>();
       setAppointments();
   }
   /**
    * Parameterized Constructor
    * @param userName String for the userName
    * @param password String for the password
    */
   public User(String userName, String password) {
       firstName = new String();
       lastName = new String();
       this.userName = new String(userName);
       //this.password = new Password(password);
       this.password = password;
       idNumber = 0;
       status = false;
       contactList = new ArrayList<String>();
       apptList = new ArrayList<Appointment>();
       phoneNumber = new String();
       address = new String();
       groupMembership = new ArrayList<String>();
       setAppointments();
   }
   /**
    * setUserName - sets user name variable
    * @param userName String for the userName
    */
   public void setUserName(String userName) {
       this.userName = userName;
   }
   /**
    * getUserName - returns username
    * @return String for UserName
    */
   public String getUserName() {
       return userName;
   }
   /**
    * setFirstName - sets user first name
    * @param firstName String for the firstName
    */
   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }
   /**
    * getFirstName - returns user first name
    * @return String for the firstName
    */
   public String getFirstName() {
       return firstName;
   }
   /**
    * setLastName - sets user last name
    * @param lastName String for the lastName
    */
   public void setLastName(String lastName) {
       this.lastName = lastName;
   }
   /**
    * getLastName - returns users last name
    * @return String for the last name
    */
   public String getLastName() {
       return lastName;
   }
   /**
    * setPassword - sets user password variable
    * 
    * @param password String for the password
    */
   public void setPassword(String password) {
       this.password = password;
   }
   /**
    * getPassword - returns the users password
    * @return String password variable
    */
   public String getPassword() {
       return this.password;
   }
   /**
    * setIDNumber - sets users ID number
    * @param id int for ID number
    */
   public void setIdNumber(int id) {
       this.idNumber = id;
   }
   /**
    * getIdNumber - returns users ID number
    * @return int for idNumber
    */
   public int getIdNumber() {
       return idNumber;
   }
   /**
    * addAppointment - adds Appointment object to the users Appt arraylist
    * @param appt Appointment object
    */
   public void addAppointment(Appointment appt) {
       apptList.add(appt);
       Collections.sort(apptList);
   }
   /**
    * remAppointment - removes Appointment from the users Appt arraylist
    * @param appt Appointment object
    */
   public void remAppointment(Appointment appt) {
       apptList.remove(appt);
       Collections.sort(apptList);
   }
   /**
    * checkAppointment - checks if a User has a pending appointment
    * @return a boolean if appointment reminder time is now
    */
   public boolean checkAppointment() {
       return apptList.get(0).checkReminder();
   }
   /**
    * setUserStatus - sets the users status
    * @param b boolean indicating user status
    */
   public void setUserStatus(boolean b) {
       this.status = b;
   }
   /**
    * getUserStatus - returns the users status
    * @return boolean for status
    */
   public boolean getUserStatus() { 
    return status;
   }
   /**
    * setAddress - sets user's address
    * @param address String for users address
    */
   public void setAddress(String address) {
       this.address = address;
   }
   /**
    * getAddress - returns users address
    * @return String for the users address
    */
   public String getAddress() {
       return address;
   }
   /**
    * setPhoneNumber - sets users phone number
    * @param phoneNumber String for the users phone number
    */
   public void setPhoneNumber(String phoneNumber) {
       this.phoneNumber = phoneNumber;
   }
   /**
    * toString - returns user info as a string
    * @return String for users info
    */
   @Override
   public String toString() {
       String s = new String(firstName + " " + lastName + " " + userName);
       return s;
   }
   /**
    * setAppointments - reads database and adds appointments to arraylist
    */
   private void setAppointments() {
       String url = new String("jdbc:sqlite:user.db");
       AppointmentDB apptdb = new AppointmentDB(url);
       ArrayList<Appointment> appts;
       appts = apptdb.getData(userName);
       this.apptList = appts;
   }
   /**
    * getAppointments - returns arraylist of users appointments
    * @param year year variable to search
    * @param month month variable to search
    * @param day day variable to search
    * @return ArrayList of appointments
    */
   public ArrayList getAppointments(int year, int month, int day) {
       ArrayList<Appointment> appts = new ArrayList();
       for (Appointment a : apptList) {
           if ((a.getStartYear() == year) && (a.getStartMonth() == month) && (a.getStartDay() == day)) {
               appts.add(a);
           }
       }
       return appts;
   }
   
}  
