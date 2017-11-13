/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Никита
 */
public class RepositoryTest {
    
    /**
     * Test of getName method, of class Repository.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Repository instance = new Repository();
        instance.setName("name");
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Repository.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Repository instance = new Repository();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getUrl method, of class Repository.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        Repository instance = new Repository();
        instance.setUrl("url");
        String expResult = "url";
        String result = instance.getUrl();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUrl method, of class Repository.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String url = "url";
        Repository instance = new Repository();
        instance.setUrl(url);
        assertEquals(url, instance.getUrl());

    }

    /**
     * Test of getStars method, of class Repository.
     */
    @Test
    public void testGetStars() {
        System.out.println("getStars");
        Repository instance = new Repository();
        instance.setStars(1);
        int expResult = 1;
        int result = instance.getStars();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStars method, of class Repository.
     */
    @Test
    public void testSetStars() {
        System.out.println("setStars");
        int stars = 0;
        Repository instance = new Repository();
        instance.setStars(stars);
        assertEquals(stars, instance.getStars());

    }

    /**
     * Test of getDescription method, of class Repository.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Repository instance = new Repository();
        instance.setDescription("desc");
        String expResult = "desc";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Repository.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "desc";
        Repository instance = new Repository();
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());

    }

    /**
     * Test of getLanguage method, of class Repository.
     */
    @Test
    public void testGetLanguage() {
        System.out.println("getLanguage");
        Repository instance = new Repository();
        instance.setLanguage("lang");
        String expResult = "lang";
        String result = instance.getLanguage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLanguage method, of class Repository.
     */
    @Test
    public void testSetLanguage() {
        System.out.println("setLanguage");
        String language = "lang";
        Repository instance = new Repository();
        instance.setLanguage(language);
        assertEquals(language, instance.getLanguage());

    }

    /**
     * Test of getCommitsNum method, of class Repository.
     */
    @Test
    public void testGetCommitsNum() {
        System.out.println("getCommitsNum");
        Repository instance = new Repository();
        int expResult = 0;
        int result = instance.getCommitsNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCommitsNum method, of class Repository.
     */
    @Test
    public void testSetCommitsNum() {
        System.out.println("setCommitsNum");
        int commitsNum = 0;
        Repository instance = new Repository();
        instance.setCommitsNum(commitsNum);
        assertEquals(commitsNum, instance.getCommitsNum());
    }

    /**
     * Test of getTopContributors method, of class Repository.
     */
    @Test
    public void testGetTopContributors() {
        System.out.println("getTopContributors");
        Repository instance = new Repository();
        instance.setTopContributors(new ArrayList<>(5));
        ArrayList<Contributor> expResult = new ArrayList<>(5);
        ArrayList<Contributor> result = instance.getTopContributors();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTopContributors method, of class Repository.
     */
    @Test
    public void testSetTopContributors() {
        System.out.println("setTopContributors");
        ArrayList<Contributor> topContributors = new ArrayList<>();
        Repository instance = new Repository();
        instance.setTopContributors(topContributors);
        assertEquals(topContributors, instance.getTopContributors());
    }

    /**
     * Test of toString method, of class Repository.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Repository rep = new Repository("torvalds/linux",
                "https://github.com/torvalds/linux",
                51839,
                "Linux kernel source tree",
                "C");
        rep.setCommitsNum(991);
        ArrayList<Contributor> contributors = new ArrayList<>();
        contributors.add(new Contributor("", 230 ));
        contributors.add(new Contributor("torvalds", 194));
        contributors.add(new Contributor("davem330", 142));
        contributors.add(new Contributor("ralfbaechle", 78));
        contributors.add(new Contributor("lag-linaro", 43));
        rep.setTopContributors(contributors);

        String expResult = "Repository{\n" +
"	Name = torvalds/linux, \n" +
"	Url = https://github.com/torvalds/linux, \n" +
"	Stars = 51839, \n" +
"	Description = Linux kernel source tree, \n" +
"	Language = C, \n" +
"	Commits = 991, \n" +
"	Top Contributors = [\n" +
"	Contributor:  has made 230 commits, \n" +
"	Contributor: torvalds has made 194 commits, \n" +
"	Contributor: davem330 has made 142 commits, \n" +
"	Contributor: ralfbaechle has made 78 commits, \n" +
"	Contributor: lag-linaro has made 43 commits]\n" +
"}\n";
        String result = rep.toString();
        assertEquals(expResult, result);
    }
    
}
