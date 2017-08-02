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
public class HistoryList implements Serializable {
    
    private ArrayList listOfHistory = new ArrayList();
    private String listOfHistoryFileName = "history.ser";
    
    public HistoryList() {

        if(listOfHistory.isEmpty() || listOfHistory == null) {
            this.createTestHistoryList();
            this.writeHistoryListFile();
            this.readHistoryListFile();
        }
        this.printHistoryList();
    }
    
    public void readHistoryListFile() {
        
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfHistoryFileName);
            in = new ObjectInputStream(fis);
            listOfHistory = (ArrayList)in.readObject();
            in.close();
            if(!listOfHistory.isEmpty()){
                System.out.println("There are histories in the history list");
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writeHistoryListFile() {
        
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfHistoryFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfHistory);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
   }
    
   public void createTestHistoryList() {
       
        Date date = new Date();
        for (int i = 0; i < 20; i++){
            listOfHistory.add(new History("user", i, date, "name"));
        }
        System.out.println("Test HistoryList created");
        System.out.println("The HistoryList is: "+listOfHistory);
    }
    
   public void printHistoryList() {

        System.out.println("The HistoryList has these histories:");
        for(int i = 0; i < listOfHistory.size(); i++){
            History currentHistory = (History) listOfHistory.get(i);
            System.out.println(currentHistory.getNumService() + " " + currentHistory.getUserName());
        }
    }
   
   public ArrayList getList() {
       return this.listOfHistory;
   }
    
}
