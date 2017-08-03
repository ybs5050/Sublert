
import java.text.ParseException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class Main {
    
    public static void main(String[] args) throws ParseException {
        
        /*
        //Instantiate the class containing the LinkedList in the main method.
        
        SubscriptionLinkedList ll = new SubscriptionLinkedList(0);
        System.out.println("---------Add a node with name 'Google' and price '333'----------");
        ll.addItem(new Subscription("Google", 333));
        ll.printSubscriptionList();
        System.out.println("---------Removed a node with name 'Google' and price '333'----------");
        ll.removeItem(new Subscription("Google", 333));
        ll.printSubscriptionList();
        System.out.println("---------Get a node with name 'HBO''----------");
        Subscription temp = ll.getItem("HBO");
        if(temp != null) {
            System.out.println("Name: " + temp.getSubscriptionName() + " Price: " + temp.getSubscriptionPrice());
        } else {
            System.out.println("a not found");
        }
        */
        // Start app with real values
        SubscriptionUI subUI = new SubscriptionUI();
        SubscriptionCtrl cont = new SubscriptionCtrl(subUI);
        
        
        
    }
    
}
