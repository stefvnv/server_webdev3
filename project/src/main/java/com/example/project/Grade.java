/**
 * Model - Grade
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

public class Grade {

    //create grade variables
    private String key; // year+email+module
    private String year;
    private String module;
    private String grade;

    /**
     * Constructor
     */
    public Grade(String id, String year, String module, String grade){
        this.key = id;
        this.year = year;
        this.module = module;
        this.grade = grade;
    }


    /**
     * Returns grades ID (users email)
     */
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    /**
     * Returns grades year
     */
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    /**
     * Returns grades module
     */
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }


    /**
     * Returns grades grade
     */
    public String getGrade() {
        return grade;
    }



    public void setGrade(String grade) {
        this.grade = grade;
    }
}
