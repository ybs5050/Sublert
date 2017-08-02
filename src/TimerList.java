import java.util.*;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin 
 */
public class TimerList implements Serializable {
    
    private ArrayList listOfTimer = new ArrayList();
    private String listOfTimerFileName = "timer.ser";
    
    public TimerList() {

        if(listOfTimer.isEmpty() || listOfTimer == null) {
            this.createTestTimerList();
            this.writeTimerListFile();
            this.readTimerListFile();
        }
        this.printTimerList();
    }
    
    public void readTimerListFile() {
        
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfTimerFileName);
            in = new ObjectInputStream(fis);
            listOfTimer = (ArrayList)in.readObject();
            in.close();
            if(!listOfTimer.isEmpty()){
                System.out.println("There are timers in the timer list");
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writeTimerListFile() {
        
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfTimerFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfTimer);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
   }
    
   public void createTestTimerList() {
       
        Date date = new Date();
        for (int i = 0; i < 20; i++){
            listOfTimer.add(new Timer(i, i+1));
        }
        System.out.println("Test TimerList created");
        System.out.println("The TimerList is: "+listOfTimer);
    }
    
   public void printTimerList() {

        System.out.println("The TimerList has these timers:");
        for(int i = 0; i < listOfTimer.size(); i++){
            Timer currentTimer = (Timer) listOfTimer.get(i);
            System.out.println(currentTimer.getAlertDaysPrior());
        }
    }
   
   public ArrayList getList() {
       return this.listOfTimer;
   }
    
}
