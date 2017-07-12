import java.util.*;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin 
 */
public class SubscriptionList implements Serializable  {
    
    private ArrayList listOfSubscription = new ArrayList();
    private String listOfSubscriptionFileName = "subscription.ser";
    
    public SubscriptionList() {

        if(listOfSubscription.isEmpty() || listOfSubscription == null) {
            this.createTestSubscriptionList();
            this.writeSubscriptionListFile();
            this.readSubscriptionListFile();
        }
        this.printSubscriptionList();
    }
    
    public void readSubscriptionListFile() {
        
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfSubscriptionFileName);
            in = new ObjectInputStream(fis);
            listOfSubscription = (ArrayList)in.readObject();
            in.close();
            if(!listOfSubscription.isEmpty()){
                System.out.println("There are subscriptions in the subscription list");
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writeSubscriptionListFile() {
        
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfSubscriptionFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfSubscription);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
   }
    
   public void createTestSubscriptionList() {
       
        Date date = new Date();
        for (int i = 0; i < 20; i++){
            listOfSubscription.add(new Subscription("name", i));
        }
        System.out.println("Test SubscriptionList created");
        System.out.println("The SubscriptionList is: "+listOfSubscription);
    }
    
   public void printSubscriptionList() {

        System.out.println("The SubscriptionList has these subscriptions:");
        for(int i = 0; i < listOfSubscription.size(); i++){
            Subscription currentSubscription = (Subscription) listOfSubscription.get(i);
            System.out.println(currentSubscription.getSubscriptionPrice());
        }
    }
   
   public ArrayList getList() {
       return this.listOfSubscription;
   }
    
}
