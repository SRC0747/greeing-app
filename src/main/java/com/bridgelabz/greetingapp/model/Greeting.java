package com.bridgelabz.greetingapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Greeting {
    @Id
    private int id;
    private String message;
    public Greeting(String message)
    {
        this.message = message;
    }

    public Greeting(int id, String message)
    {
        this.id = id;
        this.message = message;
    }


}
