/**
 * Model - User
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

public class User {

    // create user variables
    private String name;
    private String email;
    private String password;

    /**
     * Constructor for email and password
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    /**
     * Constructor for email and password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }



    /**
     * Returns users name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets users name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Returns users email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets users email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Returns users password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets users password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
