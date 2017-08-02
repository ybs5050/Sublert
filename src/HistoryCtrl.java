
import java.io.Serializable;
import java.util.TreeMap;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin Son
 */
public class HistoryCtrl implements Serializable {
    HistoryList currentHistoryList;
    HistoryTreeMap currentHistoryTreeMap;
    HistoryTreeMapTableView historyTreeMapTableView;
    HistoryTreeMapNew historyTreeMapNew;
    
    public HistoryCtrl() {
        
        // Get the current HistoryList
       // currentHistoryList = new HistoryList();   
       
       // Get the current HistoryTreeMap
       currentHistoryTreeMap = new HistoryTreeMap(0);
       
    }
    
    public HistoryTreeMapTableView getHistoryMapTableView(int x, int y) {
        historyTreeMapTableView = new HistoryTreeMapTableView(this, currentHistoryTreeMap.getMap());
        historyTreeMapTableView.setVisible(true);
        historyTreeMapTableView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historyTreeMapTableView.setLocation(x, y);
        return historyTreeMapTableView;
    }

    public HistoryTreeMapNew getHistoryNew() {
        historyTreeMapNew = new HistoryTreeMapNew(this);
        historyTreeMapNew.setVisible(true);
        historyTreeMapNew.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return historyTreeMapNew;
    }
    
    public void saveCurrentHistory() {
        currentHistoryTreeMap.writeHistoryTreeMapFile();
    }
    
    public void refreshTable(HistoryCtrl hisCtrl, TreeMap map) {
        historyTreeMapTableView.dispose();
        //HistoryTreeMapTableView HistoryCtrl hisCtrl, TreeMap historyTreeMap
        this.currentHistoryTreeMap.writeHistoryTreeMapFile();
        HistoryTreeMapTableView view = new HistoryTreeMapTableView(hisCtrl, map);
        view.setLocation(historyTreeMapTableView.getX(), historyTreeMapTableView.getY());
        historyTreeMapTableView.dispose();
        historyTreeMapTableView = view;
        view.setVisible(true);
        
    }
   
}
