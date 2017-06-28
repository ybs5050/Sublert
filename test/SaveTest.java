/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class SaveTest {
    
    public SaveTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getSaveFileDirectory method, of class Save.
     */
    @Test
    public void testGetSaveFileDirectory() {
        System.out.println("getSaveFileDirectory");
        Save instance = new Save("C:\\", "testName");
        String expResult = "C:\\";
        String result = instance.getSaveFileDirectory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSaveFileName method, of class Save.
     */
    @Test
    public void testGetSaveFileName() {
        System.out.println("getSaveFileName");
        Save instance = new Save("C:\\", "testName");
        String expResult = "testName";
        String result = instance.getSaveFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSaveFileDirectory method, of class Save.
     */
    @Test
    public void testSetSaveFileDirectory() {
        System.out.println("setSaveFileDirectory");
        String saveFileDirectory = "D:\\";
        Save instance = new Save("C:\\", "testName");
        instance.setSaveFileDirectory(saveFileDirectory);
        assertEquals(saveFileDirectory, instance.getSaveFileDirectory());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSaveFileName method, of class Save.
     */
    @Test
    public void testSetSaveFileName() {
        System.out.println("setSaveFileName");
        String saveFileName = "newName";
        Save instance = new Save("C:\\", "testName");
        instance.setSaveFileName(saveFileName);
        assertEquals(saveFileName, instance.getSaveFileName());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
