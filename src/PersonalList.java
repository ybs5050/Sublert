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
public class PersonalList implements Serializable {
    
    private ArrayList listOfPersonal = new ArrayList();
    private String listOfPersonalFileName = "personal.ser";
    
    public PersonalList() {

        if(listOfPersonal.isEmpty() || listOfPersonal == null) {
            this.createTestPersonalList();
            this.writePersonalListFile();
            this.readPersonalListFile();
        }
        this.printPersonalList();
    }
    
    public void readPersonalListFile() {
        
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfPersonalFileName);
            in = new ObjectInputStream(fis);
            listOfPersonal = (ArrayList)in.readObject();
            in.close();
            if(!listOfPersonal.isEmpty()){
                System.out.println("There are personals in the personal list");
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writePersonalListFile() {
        
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfPersonalFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfPersonal);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
   }
    
   public void createTestPersonalList() {
       
        Date date = new Date();
        for (int i = 0; i < 20; i++){
            listOfPersonal.add(new Personal("name", i, "email", "timezone"));
        }
        System.out.println("Test PersonalList created");
        System.out.println("The PersonalList is: "+listOfPersonal);
    }
    
   public void printPersonalList() {

        System.out.println("The PersonalList has these personals:");
        for(int i = 0; i < listOfPersonal.size(); i++){
            Personal currentPersonal = (Personal) listOfPersonal.get(i);
            System.out.println(currentPersonal.getNumService() + " " + currentPersonal.getUserEmail());
        }
    }
   
   public ArrayList getList() {
       return this.listOfPersonal;
   }
    
}
