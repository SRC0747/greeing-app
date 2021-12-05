package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Purpose : Implement the interface which extends database operations using JpaRepository
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 02-12-2021
 */

public interface GreetingAppRepository extends JpaRepository<Greeting, Integer> {
}
