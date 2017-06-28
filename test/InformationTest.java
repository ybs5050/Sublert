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
public class InformationTest {
    
    public InformationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getUserName method, of class Information.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Information instance = new Information("testUserName", 1);
        String expResult = "testUserName";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNumService method, of class Information.
     */
    @Test
    public void testGetNumService() {
        System.out.println("getNumService");
        Information instance = new Information("testUserName", 4);
        int expResult = 4;
        int result = instance.getNumService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Information.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "differentUserName";
        Information instance = new Information("testUserName", 4);
        instance.setUserName(userName);
        assertEquals(userName,instance.getUserName());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumService method, of class Information.
     */
    @Test
    public void testSetNumService() {
        System.out.println("setNumService");
        int numService = 2;
        Information instance = new Information("testUserName", 4);
        instance.setNumService(numService);
        assertEquals(numService,instance.getNumService());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
