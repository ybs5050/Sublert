
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
public class Timer implements Serializable {
    
    private int alertDaysPrior = 0;
    private int alertFrequency = 0;
    
    public Timer(int alertDaysPrior, int alertFrequency) {
        this.alertDaysPrior = alertDaysPrior;
        this.alertFrequency = alertFrequency;
    }
    
    public int getAlertDaysPrior() {
        return alertDaysPrior;
    }
    
    public int getAlertFrequency() {
        return alertFrequency;
    }
    
    public void setAlertDaysPrior(int alertDaysPrior) {
        this.alertDaysPrior = alertDaysPrior;
    }
    
    public void setAlertFrequency(int alertFrequency) {
        this.alertFrequency = alertFrequency;
    }
    
}
