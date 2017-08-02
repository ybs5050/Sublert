
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class Personal extends Information implements Serializable {
    //Inherit Information class
    
    private String userEmail = "";
    private String timeZone = "";
    
    public Personal(String userName, int numService, String userEmail, String timeZone) {
        super(userName, numService);
        this.userEmail = userEmail;
        this.timeZone = timeZone;
    }
    
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public String getTimeZone() {
        return this.timeZone;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public void setTimeZone (String timeZone) {
        this.timeZone = timeZone; 
    }
    
    @Override
    public void showInformation() {
        System.out.println("User Email: "+this.userEmail+" Time Zone: "+this.timeZone);
    }
    
}
