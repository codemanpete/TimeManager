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
public class Asset {
    
    private String name;
    private boolean inUse;
    
    public Asset(String name) {
        this.name = name;
        inUse = false;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean getInUse() {
        return inUse;
    }
    
    public void setUse(boolean inUse) {
        this.inUse = inUse;
    }
}
