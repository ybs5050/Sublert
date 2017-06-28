
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin Son
 */
public class SubscriptionTableModel extends AbstractTableModel{

    private ArrayList<Subscription> subUIList;
    private String[] columnNames = {"Subscription Name", "Subscription Price", "Renewal/End Date"};
    
    public SubscriptionTableModel(ArrayList<Subscription> newUIList) {
        this.subUIList = newUIList;
    }
    
    @Override
    public int getRowCount() {
        return subUIList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return columnNames[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex) {
             case 0:
                 // return sub name
                 return (Object) subUIList.get(rowIndex).getSubscriptionName();
             case 1:
                 // return sub price
                 return (Object) subUIList.get(rowIndex).getSubscriptionPrice();
             case 2:
                 // return sub date
                 return (Object) subUIList.get(rowIndex).getSubscriptionDate();
             default:
                 return null;
         }
    }
    
}
