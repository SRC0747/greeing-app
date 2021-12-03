package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

import java.util.Optional;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Optional<Greeting> editGreetingById(int id, String name);
}
