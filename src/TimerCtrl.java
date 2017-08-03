
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
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
public class TimerCtrl implements Serializable{
    
    TimerList currentTimerList;
    TimerHashMap currentTimerHashMap;
    TimerHashMapTableView timerHashMapTableView;
    TimerHashMapNew timerHashMapNew;
    
    public TimerCtrl() throws ParseException {
        // Get the current TimerList
        //currentTimerList = new TimerList();   
        currentTimerHashMap = new TimerHashMap(0);
        
    }

    public TimerHashMapTableView getTimerMapTableView(int x, int y) {
       timerHashMapTableView = new TimerHashMapTableView(this, currentTimerHashMap.getMap());
       timerHashMapTableView.setVisible(true);
       timerHashMapTableView.setTitle("Alert Times");
       timerHashMapTableView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       timerHashMapTableView.setLocation(x, y);
       return timerHashMapTableView;
    }
    
    public void saveCurrentTimer() {
        currentTimerHashMap.writeTimerHashMapFile();
    }

    public TimerHashMapNew getTimerNew(TimerCtrl timerCtrl, HashMap map) {
        timerHashMapNew = new TimerHashMapNew(this);
        timerHashMapNew.setVisible(true);
        timerHashMapNew.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return timerHashMapNew;
    }

    public void refreshTable(TimerCtrl timerCtrl, HashMap map) {
        timerHashMapTableView.dispose();
        this.currentTimerHashMap.writeTimerHashMapFile();
        TimerHashMapTableView view = new TimerHashMapTableView(timerCtrl, map);
        view.setLocation(timerHashMapTableView.getX(), timerHashMapTableView.getY());
        timerHashMapTableView.dispose();
        timerHashMapTableView = view;
        view.setVisible(true);
    }
}
