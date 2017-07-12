
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

//Base model class
public class Subscription implements Serializable {
    
    private String subscriptionName = "";
    private String subscriptionLogoURL = "";
    private double subscriptionPrice = 0;
    
    public Subscription(String subscriptionName, double subscriptionPrice) {
        this.subscriptionName = subscriptionName;
        this.subscriptionPrice = subscriptionPrice;
    }
    
    public Subscription(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
    
    public Subscription(String subscriptionName, double subscriptionPrice, String subscriptionLogoURL) {
        this.subscriptionName = subscriptionName;
        this.subscriptionPrice = subscriptionPrice;
        this.subscriptionLogoURL = subscriptionLogoURL;
    }
    
    public String getSubscriptionName() {
        return subscriptionName;
    }
    
    public String getSubscriptionLogoURL() {
        return subscriptionLogoURL;
    }
    
    public double getSubscriptionPrice() {
        return subscriptionPrice;
    }
    
    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
    
    public void setSubscriptionLogoURL(String subscriptionLogoURL) {
        this.subscriptionLogoURL = subscriptionLogoURL;
    }
    
    public void setSubscriptionPrice(double subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }
    
}
