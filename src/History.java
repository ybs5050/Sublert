import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin 
 */
public class History extends Information {
    
    private LinkedHashMap<String, Date> alertHistory = new LinkedHashMap<>();
    
    public History(String userName, int numSubscription) {
        super(userName, numSubscription);
    }
    
    public LinkedHashMap<String, Date> getAlertHistory () {
        return this.alertHistory;
    }
    
    public void addHistory (Subscription newSubscription, Date date) {
        this.alertHistory.put(newSubscription.getSubscriptionName(), date);
    }
    
    @Override
    public void showInformation() {
        System.out.println("Alert History---");
        Set set = alertHistory.entrySet();
        Iterator it = set.iterator(); //alertHistory iterator
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("Subscription Name: "+entry.getKey()+" Alerted Date: "+entry.getValue());
        }
    }
    
}
