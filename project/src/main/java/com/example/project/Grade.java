/**
 * Model - Grade
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

public class Grade {

    //create grade variables
    private String year;
    private String module;
    private String grade;
    private String email;


    /**
     * Constructor
     */
    public Grade(String year, String module, String grade, String email) {
        this.year = year;
        this.module = module;
        this.grade = grade;
        this.email = email;
    }


    /**
     * Returns grades year
     */
    public String getYear() {
        return year;
    }


    /**
     * Sets grades year
     */
    public void setYear(String year) {
        this.year = year;
    }


    /**
     * Returns grades module
     */
    public String getModule() {
        return module;
    }


    /**
     * Sets grades module
     */
    public void setModule(String module) {
        this.module = module;
    }


    /**
     * Returns grades grade
     */
    public String getGrade() {
        return grade;
    }


    /**
     * Sets grades grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }


    /**
     * Returns grades email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets grades email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
