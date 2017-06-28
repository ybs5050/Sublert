
import java.util.ArrayList;
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
public class SubscriptionList {
    
    ArrayList<Subscription> subscriptionList;
    
    public SubscriptionList() {
        //instantiate the list of model objects
        this.subscriptionList = new ArrayList<Subscription>();
        
        //fill in model objects with data
        
        subscriptionList.add(new Subscription("Amazon Prime", 9.99, "11/22/2017"));
        subscriptionList.add(new Subscription("Netflix", 7.99, "1/1/18"));
        subscriptionList.add(new Subscription("Hulu Plus", 12.59, "3/3/13"));
        subscriptionList.add(new Subscription("YouTube Red", 5.99, "5/5/21"));
        subscriptionList.add(new Subscription("Pandora", 3.99, "3/21/33"));
        
        
        /*
        // Print added objects
        for(Subscription a: subscriptionList) {
            System.out.println(a.getSubscriptionName() + " " + a.getSubscriptionPrice());
        }
        System.out.println("----------------------------------------------------------------");
        */
    }
    
    public ArrayList<Subscription> getSubscriptionList() {
        return subscriptionList;
    }
    
    public void setSubscriptionList(ArrayList<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }
    
    public void updateList(String name, double price, String date, int pos) {
        this.subscriptionList.set(pos, new Subscription(name, price, date));
    }
      
}
