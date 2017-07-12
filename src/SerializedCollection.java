
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class SerializedCollection {
    
    private HistoryCtrl theHistoryCtrl;
    private SubscriptionCtrl theSubscriptionCtrl;
    private TimerCtrl theTimerCtrl;
    private PersonalCtrl thePersonalCtrl;
    
    public SerializedCollection() {
        
        System.out.println("testing History class ");
        this.theHistoryCtrl= new HistoryCtrl();
        System.out.println("-------------------------------------");
        System.out.println("testing Subscription class ");
        this.theSubscriptionCtrl = new SubscriptionCtrl();
        System.out.println("-------------------------------------");
        System.out.println("testing Timer class ");
        this.theTimerCtrl = new TimerCtrl();
        System.out.println("-------------------------------------");
        System.out.println("testing Personal class ");
        this.thePersonalCtrl = new PersonalCtrl();
        System.out.println("-------------------------------------");
    }
    
    public ArrayList getSubscriptionList() {
        return this.theSubscriptionCtrl.currentSubscriptionList.getList();
    }
    
    public ArrayList getHistoryList() {
        return this.theHistoryCtrl.currentHistoryList.getList();
    }
    
    public ArrayList getTimerList() {
        return this.theTimerCtrl.currentTimerList.getList();
    }
    
    public ArrayList getPersonalList() {
        return this.thePersonalCtrl.currentPersonalList.getList();
    }
    
}
