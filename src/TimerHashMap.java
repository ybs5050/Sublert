
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class TimerHashMap implements Serializable {
    
    private HashMap<Subscription, Timer> timerHashMap;
    private String hashMapOfTimerFileName = "timer.ser";
    
    public TimerHashMap() {
        this.timerHashMap = new HashMap<>();
        readTimerHashMapFile();
        printTimerHashMapList();
        
    }
    
    // Constructor for testing purpose 
    public TimerHashMap(int option) throws ParseException {
        this.timerHashMap = new HashMap<>();
        
        // Test Data
        if(option == 0) {
            Subscription s1 = new Subscription("Netflix", 5.21, "11/01/17");
            Subscription s2 = new Subscription("Amazon Prime", 3.99, "09/01/17");
            Subscription s3 = new Subscription("Hulu Plus", 1.82, "12/25/17");
            Subscription s4 = new Subscription("Apple Music", 2.82, "3/25/17");
            Subscription s5 = new Subscription("Pandora", 9.99, "07/31/17");
            
            Timer t1 = new Timer(1,1,"5:0:0");
            Timer t2 = new Timer(3,1, "15:30:0");
            Timer t3 = new Timer(2,2, "14:25:0");
            Timer t4 = new Timer(5,1, "3:0:0");
            Timer t5 = new Timer(2,2, "13:21:0");
            
            this.addItem(s1, t1);
            this.addItem(s2, t2);
            this.addItem(s3, t3);
            this.addItem(s4, t4);
            this.addItem(s5, t5);
            
            System.out.println("Added Test Data: ");
            
        }
        this.printTimerHashMapList();
    }
    
    public void readTimerHashMapFile() {
        
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(hashMapOfTimerFileName);
            in = new ObjectInputStream(fis);
            timerHashMap = (HashMap)in.readObject();
            in.close();
            if(!timerHashMap.isEmpty()){
                System.out.println("There are histories in the history tree map");
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writeTimerHashMapFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(hashMapOfTimerFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(timerHashMap);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void printTimerHashMapList() {
        System.out.println("The Timer Hash Map has these objects: ");
        for(Subscription temp : this.timerHashMap.keySet()) {
            System.out.println("Subscription Name: " + temp.getSubscriptionName() + " " + 
                    "Subscription Renewal/End Date: " + temp.getSubscriptionDate() + " " + 
                    "Alert Time: " + this.timerHashMap.get(temp).getTime()
                    );
        }
    }
    
    public void addItem(Subscription newSubscription, Timer newTimer) {
        this.timerHashMap.put(newSubscription, newTimer);
    }
    
    public boolean removeItem(Subscription sub) {
        if(!this.timerHashMap.containsKey(sub)) {
            return false;
        } else {
            this.timerHashMap.remove(sub);
            return true;
        }
    }
    
    public boolean hasItem(String subscriptionName) {
        return this.timerHashMap.containsKey(new Subscription(subscriptionName));
    }
    
    public int size() {
        return this.timerHashMap.size();
    }
    
    public HashMap getMap() {
        return this.timerHashMap;
    }
    
}
