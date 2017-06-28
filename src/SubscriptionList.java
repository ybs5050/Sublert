
import java.util.ArrayList;

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
        
        subscriptionList.add(new Subscription("Amazon Prime", 9.99));
        subscriptionList.add(new Subscription("Netflix", 7.99));
        subscriptionList.add(new Subscription("Hulu Plus", 12.59));
        subscriptionList.add(new Subscription("YouTube Red", 5.99));
        subscriptionList.add(new Subscription("Pandora", 3.99));
        
        /*
        // Print added objects
        for(Subscription a: subscriptionList) {
            System.out.println(a.getSubscriptionName() + " " + a.getSubscriptionPrice());
        }
        System.out.println("----------------------------------------------------------------");
        */
    }
      
}
