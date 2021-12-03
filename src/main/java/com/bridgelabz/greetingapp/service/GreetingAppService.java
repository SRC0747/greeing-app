package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class GreetingAppService implements IGreetingService {

    private static final String template = "Hello, %s!";
    @Autowired
    GreetingAppRepository greetingAppRepository;

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

    public List<Greeting> getAll() {
        return greetingAppRepository.findAll();
    }

    public Optional<Greeting> editGreetingById(int id, String name) {
        Optional<Greeting> particularGreeting = greetingAppRepository.findById(id);
        particularGreeting.get().setMessage(name);
        return particularGreeting;
    }

    public void delete(int id) {
        greetingAppRepository.deleteById(id);
    }
}
