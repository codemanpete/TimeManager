/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewwindowdriver;
import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Sean
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
   
   public void setUserName(String userName) {
       this.userName = userName;
   }
   
   public String getUserName() {
       return userName;
   }
   
   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }
   
   public String getFirstName() {
       return firstName;
   }
   
   public void setLastName(String lastName) {
       this.lastName = lastName;
   }
   
   public String getLastName() {
       return lastName;
   }
  /* 
   public void setPassword(String password) {
       this.password = new Password(password);
   }*/
   /*
   public boolean checkPassword(String password) {
      return this.password.checkPassword(password);
   }*/
   
   public void setPassword(String password) {
       this.password = password;
   }
   
   public String getPassword() {
       return this.password;
   }
   
   public void setIdNumber(int id) {
       this.idNumber = id;
   }
   
   public int getIdNumber() {
       return idNumber;
   }
   
   public void addAppointment(Appointment appt) {
       apptList.add(appt);
       Collections.sort(apptList);
   }
   
   public void remAppointment(Appointment appt) {
       apptList.remove(appt);
       Collections.sort(apptList);
   }
   
   public boolean checkAppointment() {
       return apptList.get(0).checkReminder();
   }
   
   public void setUserStatus(boolean b) {
       this.status = b;
   }
   
   public boolean getUserStatus() { 
    return status;
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
   
   @Override
   public String toString() {
       String s = new String(firstName + " " + lastName + " " + userName);
       return s;
   }
   
   private void setAppointments() {
       String url = new String("jdbc:sqlite:timemanager.db");
       AppointmentDB apptdb = new AppointmentDB(url);
       ArrayList<Appointment> appts;
       appts = apptdb.getData(userName);
       this.apptList = appts;
   }
   
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
 