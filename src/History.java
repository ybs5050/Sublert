import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin 
 */
public class History extends Information implements Serializable {
    
    private String subscription = "";
    private Date date;
    
    public History(String userName, int numSubscription, Date date, String subscription) {
        super(userName, numSubscription);
        this.date = date;
        this.subscription = subscription;
    }
    
    @Override
    public void showInformation() {
            System.out.println("Subscription Name: "+ this.subscription + " Alerted Date: " + this.date.toString());
    }

    
}
