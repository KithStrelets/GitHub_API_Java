/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Никита
 */
public class ContributorTest {
    
    Contributor contributor = new Contributor("test", 0);
    /**
     * Test of getName method, of class Contributor.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Contributor instance = contributor;
        String expResult = "test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Contributor.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "test1";
        Contributor instance = contributor;
        instance.setName(name);
        assertEquals(instance.getName(), name);
    }

    /**
     * Test of getCommitNum method, of class Contributor.
     */
    @Test
    public void testGetCommitNum() {
        System.out.println("getCommitNum");
        Contributor instance = contributor;
        int expResult = 0;
        int result = instance.getCommitNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCommitNum method, of class Contributor.
     */
    @Test
    public void testSetCommitNum() {
        System.out.println("setCommitNum");
        int commitNum = 1;
        Contributor instance = contributor;
        instance.setCommitNum(commitNum);
        assertEquals(commitNum, instance.getCommitNum());
    }

    /**
     * Test of toString method, of class Contributor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Contributor instance = contributor;
        String expResult = "\n\tContributor: test has made 0 commits";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
