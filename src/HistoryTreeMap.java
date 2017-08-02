
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class HistoryTreeMap implements Serializable {
    
    private TreeMap<History, Subscription> historyTreeMap;
    private String treeMapOfHistoryFileName = "history.ser";
    
    public HistoryTreeMap() {
        this.historyTreeMap = new TreeMap<>();
        readHistoryTreeMapFile();
        printHistoryTreeMapList();
    }
    
    // Constructor for testing purpose
    public HistoryTreeMap(int option) {
        this.historyTreeMap = new TreeMap<>();
        
        // Test Data 
        if(option == 0) {
            Subscription s1 = new Subscription("Netflix", 5.21, "11/01/17");
            Subscription s2 = new Subscription("Amazon Prime", 3.99, "09/01/17");
            Subscription s3 = new Subscription("Hulu Plus", 1.82, "12/25/17");
            Subscription s4 = new Subscription("Apple Music", 2.82, "3/25/17");
            Subscription s5 = new Subscription("Pandora", 9.99, "07/31/17");
            
            this.addItem(new History(new Date(s1.getSubscriptionDate()), s1.getSubscriptionName()), s1);
            this.addItem(new History(new Date(s2.getSubscriptionDate()), s2.getSubscriptionName()), s2);
            this.addItem(new History(new Date(s3.getSubscriptionDate()), s3.getSubscriptionName()), s3);
            this.addItem(new History(new Date(s4.getSubscriptionDate()), s4.getSubscriptionName()), s4);
            this.addItem(new History(new Date(s5.getSubscriptionDate()), s5.getSubscriptionName()), s5);
            
            System.out.println("Added Test Data: ");
        }
        this.printHistoryTreeMapList();
    }
    
    public void readHistoryTreeMapFile() {
        
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(treeMapOfHistoryFileName);
            in = new ObjectInputStream(fis);
            historyTreeMap = (TreeMap)in.readObject();
            in.close();
            if(!historyTreeMap.isEmpty()){
                System.out.println("There are histories in the history tree map");
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writeHistoryTreeMapFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(treeMapOfHistoryFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(historyTreeMap);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void printHistoryTreeMapList() {
        System.out.println("The History Tree Map has these histories:");
        for(History aa : this.historyTreeMap.keySet()) {
            System.out.println("Alerted Date: " + aa.getDate() + " " + 
                    "Subscription Name: " + this.historyTreeMap.get(aa).getSubscriptionName());
        }
        
    }
    
    public void addItem(History newHistory, Subscription newSubscription) {
        this.historyTreeMap.put(newHistory, newSubscription);
    }
    
    public boolean removeItem(History his) {
        if(!this.historyTreeMap.containsKey(his)) {
            return false;
        } else {
            this.historyTreeMap.remove(his);
            return true;
        }
    }
    
    public boolean hasItem(String historyDate, String SubscriptionName) {
        return this.historyTreeMap.containsKey(new History(new Date(historyDate), SubscriptionName));
    }
    
    public int size() {
        return this.historyTreeMap.size();
    }
    
    public TreeMap getMap() {
        return this.historyTreeMap;
    }
    
    
}
