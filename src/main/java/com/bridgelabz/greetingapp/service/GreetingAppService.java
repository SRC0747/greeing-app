package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class GreetingAppService implements IGreetingService {

    @Autowired
    GreetingAppRepository greetingAppRepository;
    private static final String template = "Hello, %s!";

    public String greet() {
        return "Hello World";
    }

    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingAppRepository.save(new Greeting(message));
    }

    public Optional<Greeting> findById(int id) {
        return greetingAppRepository.findById(id);
    }
}
