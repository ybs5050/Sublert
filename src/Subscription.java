
import java.text.SimpleDateFormat;
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

//Base model class
public class Subscription {
    
    private String subscriptionName = "";
    private String subscriptionLogoURL = "";
    private double subscriptionPrice = 0;
    private Date subscriptionDate = new Date();
    
    public Subscription(String subscriptionName, double subscriptionPrice) {
        this.subscriptionName = subscriptionName;
        this.subscriptionPrice = subscriptionPrice;
    }
    
    public Subscription(String subscriptionName, double subscriptionPrice, String subscriptionDate) {
        this.subscriptionName = subscriptionName;
        this.subscriptionPrice = subscriptionPrice;
        this.subscriptionDate = new Date(subscriptionDate);
    }
    
    public Subscription(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
    
    public Subscription(String subscriptionName, double subscriptionPrice, String subscriptionDate, String subscriptionLogoURL) {
        this.subscriptionName = subscriptionName;
        this.subscriptionPrice = subscriptionPrice;
        this.subscriptionLogoURL = subscriptionLogoURL;
        this.subscriptionDate = new Date(subscriptionDate);
    }
    
    public String getSubscriptionName() {
        return subscriptionName;
    }
    
    public String getSubscriptionLogoURL() {
        return subscriptionLogoURL;
    }
    
    public String getSubscriptionPrice() {
        return Double.toString(subscriptionPrice);
    }
    
    public String getSubscriptionDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return new String(formatter.format(this.subscriptionDate));
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
    
    public void setSubscriptionDate(String date) {
        this.subscriptionDate = new Date(date);
    }
    
    
}
