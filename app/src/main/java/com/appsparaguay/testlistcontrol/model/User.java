package com.appsparaguay.testlistcontrol.model;

/**
 * Created by Administrador on 9/7/2015.
 */
public class User {
    private String firstName;
    private String lastName;
    public User() {}
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}