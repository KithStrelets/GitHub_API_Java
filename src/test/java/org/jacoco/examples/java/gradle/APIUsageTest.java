/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Никита
 */
public class APIUsageTest {
    
    APIUsage instance = new APIUsage();
    /**
     * Test of getTenMostCommited method, of class APIUsage.
     */
    @Test
    public void testGetTenMostCommited() {
        System.out.println("getTenMostCommited");
        String sinceYYYYMMDD = "2017-09-01";
        String untilYYYYMMDD = "2017-09-07";
        Metrics.start();
        ArrayList<Repository> result = instance.getTenMostCommited(instance.getMostStarredReps(), sinceYYYYMMDD, untilYYYYMMDD);
        Metrics.stop();
        Metrics.getAllMetrics();
        assertEquals(10, result.size());
        assertEquals(5, result.get(0).getTopContributors().size());
    }   
}
