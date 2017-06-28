import java.util.ArrayList;
import java.util.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class TestHarness {
    
    public TestHarness() {
      
    }
    
    public void testClasses(){
        //Test the Save class
        Save tS = new Save("C:\\", "testName");
        if(tS != null) {
            System.out.println("Test Save created successfully");
            System.out.println("Save info: "+tS.getSaveFileDirectory()+" "+tS.getSaveFileName());
            // Change Save object
            tS.setSaveFileDirectory("D:\\");
            tS.setSaveFileName("differentName");
            System.out.println("Save info: "+tS.getSaveFileDirectory()+" "+tS.getSaveFileName());
        }
        
        //Test the Information class
        Information tI = new Information("testUserName", 1);
        if(tI != null) {
            System.out.println("Test Information created successfully");
            System.out.println("Information info: "+tI.getUserName()+" "+tI.getNumService());
            // Change Information object
            tI.setUserName("differentUserName");
            tI.setNumService(3);
            System.out.println("Information info: "+tI.getUserName()+" "+tI.getNumService());
        }
    }
    
    public void testClassHierarchy() {
        
            ArrayList<Information> testInformation = new ArrayList<>();
            
            testInformation.add(new Personal("Name", 1, "blah@blah.com", "EST"));
            testInformation.add(new Personal("Name", 2, "blah@blah.com", "CST"));
            testInformation.add(new Personal("Name", 3, "blah@blah.com", "PDT"));
            testInformation.add(new Personal("Name", 4, "blah@blah.com", "NONE"));
            //Add Personal class objects to ArrayList
            
            History testHistory = new History("Name", 0);
            testHistory.addHistory(new Subscription("Service 1", 3.3), new Date());
            testHistory.addHistory(new Subscription("Service 2", 3.3), new Date());
            testHistory.addHistory(new Subscription("Service 3", 3.3), new Date());
            testHistory.addHistory(new Subscription("Service 4", 3.3), new Date());
            //Add some data for over-ridden method call purpose
            
            testInformation.add(testHistory);
            //Add History class object to ArrayList
           
            for(int i = 0; i < testInformation.size(); i++) {
                //Iterate through Arraylist
                testInformation.get(i).showInformation();
            }

    }
    
    public void testInterface() {
        
        ArrayList<Display> testInterface= new ArrayList<>();
        testInterface.add(new Monitor(0,0));
        testInterface.add(new Monitor(1,2));
        testInterface.add(new Monitor(3,3));
        testInterface.add(new Monitor(4,3));
        //Add Monitor objects to ArrayList
        
        testInterface.add(new Save("",""));
        testInterface.add(new Save("C","1"));
        testInterface.add(new Save("D","2"));      
        testInterface.add(new Save("E","3"));
        //Add Save objects to ArrayList
        
        for(int i = 0; i < testInterface.size(); i++) {
            //Iterate through Arraylist
            testInterface.get(i).showInformation();
            testInterface.get(i).checkNull();
        }
        
    }
    
//    public static void main(String[] args) {
//        // Initiate and test TestHarness class
//        TestHarness test = new TestHarness(); 
//        test.testInterface();
//    }
    
}
