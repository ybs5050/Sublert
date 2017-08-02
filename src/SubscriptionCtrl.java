
import java.io.Serializable;
import static java.lang.String.format;
import java.util.Date;
import javax.swing.JFrame;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class SubscriptionCtrl implements Serializable {
    
    // Instance Variables
    SubscriptionUI subUI;
    SubscriptionLinkedList subList;
    SubscriptionListUI subListUI;
    SubscriptionTableModel subListTableModel;
    SubscriptionListDetailUI subListDetailUI;
    SubscriptionListNew subListNew;
    
    public SubscriptionCtrl(SubscriptionUI subUI) {
        
        // Supports navigating back to the Main Menu
        this.subUI = subUI;
        
        // Get the InstrumentList
        // When instantiated it will get the individual Instruments
        subList = new SubscriptionLinkedList(0);
        
        // Show the list of model objects in the UI
        subListUI = new SubscriptionListUI(this);
        subListUI.setVisible(true);

    }
    
    public SubscriptionCtrl() {
        this.subList = new SubscriptionLinkedList();
    }

    public void deleteSubscription(int pos) {
        subListUI.dispose();
        subList.getList().remove(pos);
        subListTableModel = new SubscriptionTableModel(subList.getList());
        subList.setList(subList.getList());
        subList.writeSubscriptionListFile();
        subListUI = new SubscriptionListUI(this);
        subListUI.setVisible(true);
    }

    public void updateSubscription(String name, double price, String date, int pos) {
        subListUI.dispose();
        subList.updateList(name, price, date, pos);
        subListTableModel = new SubscriptionTableModel(subList.getList());
        subListUI = new SubscriptionListUI(this);
        subListUI.setVisible(true);
        subList.setList(subList.getList());
        subList.writeSubscriptionListFile();
    }

    public void addSubscription(String text, double subPrice, String date) {
        subListUI.dispose();
        subList.getList().add(new Subscription(text, subPrice, date));
        subListTableModel = new SubscriptionTableModel(subList.getList());
        subList.setList(subList.getList());
        subList.writeSubscriptionListFile();
        subListUI = new SubscriptionListUI(this);
        subListUI.setVisible(true);
    }
    
    public void saveCurrentSubscriptions() {
        subList.writeSubscriptionListFile();
    }

    public SubscriptionListDetailUI getSubscriptionListDetail(int selectedRow) {
        subListDetailUI = new SubscriptionListDetailUI(this, selectedRow);
        subListDetailUI.setVisible(true);
        subListDetailUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return subListDetailUI;
    }

    public SubscriptionListNew getSubscriptionNew() {
        subListNew = new SubscriptionListNew(this);
        subListNew.setVisible(true);
        subListNew.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return subListNew;
    }

    
      
}
