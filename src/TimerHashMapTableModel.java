
import java.util.ArrayList;
import java.util.Arrays;
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
public class TimerHashMapTableModel extends AbstractTableModel {
    
    private ArrayList<Timer> timerHashMap;
    private String[] columnNames = {"Alert Times", "Alert Frequency"};
    
    public TimerHashMapTableModel(TimerHashMap newHistoryHashMap) {
        this.timerHashMap = new ArrayList(Arrays.asList(newHistoryHashMap.getMap().values().toArray()));
    }
    
    @Override
    public int getRowCount() {
        return timerHashMap.size();
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
                // return time
                return (String) timerHashMap.get(rowIndex).getTime();
            case 1:
                // return alert frequency
                return (Object) timerHashMap.get(rowIndex).getAlertFrequency();
            default:
                return null;
        }
    }
    
}
