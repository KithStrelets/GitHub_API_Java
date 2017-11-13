/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

/**
 *
 * @author Никита
 */
public class Contributor {

    private String name;
    private int commitNum;
    
    public Contributor(String name, int commitNum) {
        this.name = name;
        this.commitNum = commitNum;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommitNum() {
        return commitNum;
    }

    public void setCommitNum(int commitNum) {
        this.commitNum = commitNum;
    }
    
    
    @Override
    public String toString() {
        return "\n\tContributor: "  + name + " has made " + commitNum + " commits";
    }

}
