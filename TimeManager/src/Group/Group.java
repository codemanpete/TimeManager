/**
 * Group class. For Group management
 * For CS321-02 Group Project
 * Walker, Cheng, Curtis, McEniry
 */
package Group;
import java.util.ArrayList;


/**
 *
 * @author Sean J Curtis
 */
public class Group {
   private String groupName = new String();
   private ArrayList<String> userList = new ArrayList<String>();
   private ArrayList<Integer> userIdList = new ArrayList<Integer>();
    
   /**
    * Default Constructor
    */
   public Group() {
       
   }
   /**
    * Constructor
    * @param groupName name of the group 
    */
    public Group(String groupName) {
        this.groupName = groupName;
    }
    /**
     * setGroupName - Sets the name of the group
     * @param groupName 
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    /**
     * getGroupName - returns the name of the group
     * @return String groupName
     */
    public String getGroupName() {
        return groupName;
        
    }
    
    /**
     * addUserToGroup - adds a user to the group
     * @param userName String of the userName
     * 
     */
    public void addUserToGroup(String userName) {
        userList.add(userName);
        
    }
    
    /**
     * addUserToGroup - by userID
     * @param userID 
     */
    public void addUserToGroup(int userID) {
       // userList.add(userName);
        userIdList.add(userID);
    }
    
    /**
     * remUserFromGroup - removes user from group
     * @param userName 
     */
    public void remUserFromGroup(String userName) {
        userList.remove(userName);
       ;
    }
    
    /**
     * remUserFromGroup - by userID
     * @param userID 
     */
    public void remUserFromGroup(int userID) {
        
        userIdList.remove(userID);
    }
    
    /**
     * printGroup - prints all users in group
     * @return string
     */
    public String printGroup() {
        String s = new String();
        for (String u : userList) {
            s = s + u + "\n";
            
        }
        return s;
    }
    
    /** 
     * printGroupbyID prints all userIDs in group by ID
     * @return string
     */
    public String printGroupbyID() {
        String s = new String();
        for (int u : userIdList) {
            s = s + u + "\n";
        }
        return s;
    }
    
}
