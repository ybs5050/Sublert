/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class Monitor implements Display {
    
    private int activeServices = 0;
    private int nonActiveServices = 0;
    
    public Monitor(int activeServices, int nonActiveServices) {
        this.activeServices = activeServices;
        this.nonActiveServices = nonActiveServices;
    }
    
    public int getActiveServices() {
        return activeServices;
    }
    
    public int getNonActiveServices() {
        return nonActiveServices;
    }
    
    public void setActiveServices(int activeServices) {
        this.activeServices = activeServices;
    }
    
    public void setNonActiveServices(int nonActiveServices) {
        this.nonActiveServices = nonActiveServices;
    }

    @Override
    public void showInformation() {
        System.out.println("Current # of Active Services: "+activeServices);
        System.out.println("Current # of Non-Active Services: "+nonActiveServices);
    }

    @Override
    public void checkNull() {
        String result = activeServices == 0 ? "Empty" : "Not Empty";
        System.out.println("Monitor Class is "+result);
    }
    
}
