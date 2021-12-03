package com.bridgelabz.greetingapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    public int id;
    public String firstName;
    public String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.id = 0;
    }
    public User(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}
