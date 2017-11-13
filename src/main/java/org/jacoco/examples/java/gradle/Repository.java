/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.util.ArrayList;

/**
 *
 * @author Никита
 */
public class Repository {

    private String name;
    private String url;
    private int stars;
    private String description;
    private String language;
    private int commitsNum;
    private ArrayList<Contributor> topContributors;
    
    public Repository(String name, String url, int stars, String description, String language) {
        this.name = name;
        this.url = url;
        this.stars = stars;
        this.description = description;
        this.language = language;
    }

    public Repository() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public int getCommitsNum() {
        return commitsNum;
    }

    public void setCommitsNum(int commitsNum) {
        this.commitsNum = commitsNum;
    }
    
    public ArrayList<Contributor> getTopContributors() {
        return topContributors;
    }

    public void setTopContributors(ArrayList<Contributor> topContributors) {
        this.topContributors = topContributors;
    }
    
    @Override
    public String toString() {
        return "Repository{" 
                + "\n\tName = " + name 
                + ", \n\tUrl = " + url 
                + ", \n\tStars = " + stars 
                + ", \n\tDescription = " + description 
                + ", \n\tLanguage = " + language 
                + ", \n\tCommits = " + commitsNum 
                + ", \n\tTop Contributors = " + topContributors 
                + "\n}\n";
    }
}
