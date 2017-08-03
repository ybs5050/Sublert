
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



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
    private Calendar time = GregorianCalendar.getInstance();
    
    public Timer(int alertDaysPrior, int alertFrequency) {
        this.alertDaysPrior = alertDaysPrior;
        this.alertFrequency = alertFrequency;
    }
    
    public Timer(int alertDaysPrior, int alertFrequency, String time) throws ParseException {
        this.alertDaysPrior = alertDaysPrior;
        this.alertFrequency = alertFrequency;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = sdf.parse(time);
        this.time.setTime(date);
    }
    
    public Timer(int alertFrequency, String time) throws ParseException {
        this.alertFrequency = alertFrequency;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = sdf.parse(time);
        this.time.setTime(date);
    }
    
    public int getAlertDaysPrior() {
        return alertDaysPrior;
    }
    
    public int getAlertFrequency() {
        return alertFrequency;
    }
    
    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(this.time.getTime());
    }
    
    public void setAlertDaysPrior(int alertDaysPrior) {
        this.alertDaysPrior = alertDaysPrior;
    }
    
    public void setAlertFrequency(int alertFrequency) {
        this.alertFrequency = alertFrequency;
    }
    
}
