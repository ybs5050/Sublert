
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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

//Base model class
public class Subscription implements Serializable, Comparable<Subscription>{
    
    private String subscriptionName = "";
    private String subscriptionLogoURL = "";
    private double subscriptionPrice = 0;
    private Date subscriptionDate = new Date();
    
    
    public Subscription(String subscriptionName, double subscriptionPrice) {
        this.subscriptionName = subscriptionName;
        this.subscriptionPrice = subscriptionPrice;
    }
    
    public Subscription(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
    
    public Subscription(String subscriptionName, double subscriptionPrice, String date) {
        this.subscriptionName = subscriptionName;
        this.subscriptionPrice = subscriptionPrice;
        this.subscriptionDate = new Date(date);
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
    
    public String getSubscriptionDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(this.subscriptionDate);
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

    @Override
    public int compareTo(Subscription o) {
        return o.subscriptionName.compareTo(subscriptionName);
    }
    
    @Override
    public boolean equals(Object o) {
        Subscription temp = (Subscription) o;
        return temp.subscriptionName.equals(this.subscriptionName);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.subscriptionName);
        return hash;
    }

}
