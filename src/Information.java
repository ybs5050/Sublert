/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class Information {
    
    private String userName = "";
    private int numService = 0;
    
    public Information(String userName, int numService) {
        this.userName = userName;
        this.numService = numService;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public int getNumService() {
        return numService;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setNumService(int numService) {
        this.numService = numService;
    }
    
    public void showInformation() {
        System.out.println("Name: "+this.userName+" # of Services: " +this.numService);
    }
   
}
