import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin 
 */
public class History extends Information implements Serializable, Comparable<History> {
    
    private String subscription = "";
    private Date date;
    
    
    public History(String userName, int numSubscription, Date date, String subscription) {
        super(userName, numSubscription);
        this.date = date;
        this.subscription = subscription;
        
    }
    
    public History(Date date, String subscription) {
        super("", 0);
        this.date = date;
        this.subscription = subscription;
    }
    
    public String getDate() {
        return new SimpleDateFormat("MM-dd-yyyy").format(this.date);
    }
    
    public String getName() {
        return this.subscription;
    }
    
    @Override
    public void showInformation() {
            System.out.println("Subscription Name: "+ this.subscription + " Alerted Date: " + this.date.toString());
    }

    @Override
    public int compareTo(History o) {
        return o.date.compareTo(this.date);
        //return o.subscription.compareTo(this.subscription);
    }
    
    
}
