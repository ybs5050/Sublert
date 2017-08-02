
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class HistoryTreeMapTableModel extends AbstractTableModel {
    
    private ArrayList<History> historyTreeMap;
    private String[] columnNames = {"Alerted Dates"};
    
    public HistoryTreeMapTableModel(HistoryTreeMap newHistoryTreeMap) {
        this.historyTreeMap = new ArrayList(Arrays.asList(newHistoryTreeMap.getMap().keySet().toArray()));
    }
    
    @Override
    public int getRowCount() {
        return this.historyTreeMap.size();
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
                 // return history date
                return (Object) historyTreeMap.get(rowIndex).getDate();
            case 1:
                 // return history sub name
                return (Object) historyTreeMap.get(rowIndex).getName();
            default:
                return null;
        }

    }
    
}
