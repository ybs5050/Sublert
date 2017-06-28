


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class SubscriptionCtrl {
    
    // Instance Variables
    SubscriptionUI subUI;
    SubscriptionList subList;
    SubscriptionListUI subListUI;

    public SubscriptionCtrl(SubscriptionUI subUI) {
        
        // Supports navigating back to the Main Menu
        this.subUI = subUI;
        
        // Get the InstrumentList
        // When instantiated it will get the individual Instruments
        subList = new SubscriptionList();
        
        // Show the list of model objects in the UI
        subListUI = new SubscriptionListUI(this);
        subListUI.setVisible(true);
        
    }
      
}
