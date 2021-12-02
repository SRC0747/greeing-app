package com.bridgelabz.greetingapp.model;

import javax.persistence.Entity;

@Entity
public class Greeting {
    private String message;

    public Greeting(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
    
    public void setMessage(String name)
    {
        this.message = name;
    }
}
