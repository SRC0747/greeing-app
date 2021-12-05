package com.bridgelabz.greetingapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Purpose : Contain the entities in the database
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 02-12-2021
 */

@Entity
@Data
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String message;
}
