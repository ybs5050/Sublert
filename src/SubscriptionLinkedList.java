
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class SubscriptionLinkedList implements Serializable {
    
    private LinkedList<Subscription> subscriptionLink;
    private String listOfSubscriptionFileName = "subscription.ser";
    
    public SubscriptionLinkedList() {
        this.subscriptionLink = new LinkedList<>();
        readSubscriptionListFile();
    }
    
    // Constructor for testing purpose
    public SubscriptionLinkedList(int option) {
        this.subscriptionLink = new LinkedList<>();
        
        // Test Data
        if(option == 0 ) {
            String [] alphabet = {"Netflix","Apple Music", "Amazon", "Hulu", "Paypal", "Pandora", "HBO", "Chegg"};
            System.out.println("Unsorted Objects: ");
            for(int i = 0; i < alphabet.length; i++) {
                System.out.println("Name: " + alphabet[i] + " Price: " + i);
            }
            System.out.println("Alphabetically Sorted Objects by adding to a Linked List: ");
            this.subscriptionLink = new LinkedList<>();
            for(int i = 0; i < alphabet.length; i++) {
                addItem(new Subscription(alphabet[i], i));
            }
            this.printSubscriptionList();
        }
    }
    
     public void readSubscriptionListFile() {
        
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfSubscriptionFileName);
            in = new ObjectInputStream(fis);
            subscriptionLink = (LinkedList)in.readObject();
            in.close();
            if(!subscriptionLink.isEmpty()){
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
            out.writeObject(subscriptionLink);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
   }
    
    public void printSubscriptionList() {
        
        System.out.println("The SubscriptionList has these subscriptions:");
        for(int i = 0; i < subscriptionLink.size(); i++){
            Subscription currentSubscription = (Subscription) subscriptionLink.get(i);
            System.out.println("Name: " + currentSubscription.getSubscriptionName() + " Price: " + currentSubscription.getSubscriptionPrice()
            +  " Date: " + currentSubscription.getSubscriptionDate());
        }
    }
    
    public void addItem(Subscription newObject) {
        ListIterator<Subscription> listIterator = subscriptionLink.listIterator();
        boolean insertDecision = false;
        boolean inserted = false;
        if(subscriptionLink.size() == 0) {
            subscriptionLink.add(newObject);
        } else {
            while(listIterator.hasNext()) {
                insertDecision = decideToInsert(newObject.getSubscriptionName(), listIterator.next().getSubscriptionName());
                if(insertDecision) {
                    subscriptionLink.add(listIterator.previousIndex(), newObject);
                    inserted = true;
                    break;
                }         
            }
            if(inserted == false) {
                subscriptionLink.add(newObject);
            }
        }
    }
    
    public boolean decideToInsert(String newtext, String itertext) {
        boolean decision = false;
        if(newtext.compareTo(itertext) <= 0) {
            decision = true;
        }
        return decision;
    }
    
    public void removeItem(Subscription objectToRemove) {
       for(int i = 0; i < subscriptionLink.size(); i++) {
            if(subscriptionLink.get(i).getSubscriptionName().equals(objectToRemove.getSubscriptionName())
                    && subscriptionLink.get(i).getSubscriptionPrice() == objectToRemove.getSubscriptionPrice()) {
                subscriptionLink.remove(i);
            }
        }
    }
    
    public Subscription getItem(String searchTerm) {
        
        if(searchTerm.compareTo(subscriptionLink.get(0).getSubscriptionName()) < 0 && !searchTerm.equals(subscriptionLink.get(0).getSubscriptionName())) {
            return null;
        } else if (searchTerm.equals(subscriptionLink.get(0).getSubscriptionName())){
            return subscriptionLink.get(0);
        }
        
        for(int i = 1; i < subscriptionLink.size(); i++) {
            if(subscriptionLink.get(i).getSubscriptionName().equals(searchTerm)) {
                return subscriptionLink.get(i);
            }
        }
        return null;
    }
    
    public LinkedList<Subscription> getList() {
        return this.subscriptionLink;
    }

    public void setList(LinkedList<Subscription> list) {
        this.subscriptionLink = list;
    }

    public void updateList(String name, double price, String date, int pos) {
        this.subscriptionLink.set(pos, new Subscription(name, price, date));          
   }
    
}
