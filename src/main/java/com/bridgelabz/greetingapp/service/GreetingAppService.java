package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingAppDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingAppService {

    private static final String GREETING_MESSAGE_EDITED = "Greeting message of corresponding id is successfully edited.";
    private static final String GREETING_MESSAGES_NOT_FOUND = "Greeting Message of corresponding id is not found.";
    private static final String GREETING_MESSAGE_DELETED = "Greeting Message is deleted successfully.";

    @Autowired
    GreetingAppRepository greetingAppRepository;

    public String greet() {
        return "Hello World";
    }

    public Greeting saveGreeting(GreetingAppDTO greetingAppDTO) {
        Greeting greeting = new Greeting();
        greeting.setMessage(greetingAppDTO.getMessage());
        return greetingAppRepository.save(greeting);
    }

    public Greeting getGreetingById(int id) {
        Optional<Greeting> greetById = greetingAppRepository.findById(id);
        return greetById.orElse(null);
    }

    public List<Greeting> getAll() {
        return greetingAppRepository.findAll();
    }

    public String editGreeting(int id, GreetingAppDTO greetingAppDTO) {
        Optional<Greeting> editGreetingMessageById = greetingAppRepository.findById(id);
        if(editGreetingMessageById.isPresent()){
            Greeting greeting = editGreetingMessageById.get();
            greeting.setMessage(greetingAppDTO.getMessage());
            greetingAppRepository.save(greeting);
            return GREETING_MESSAGE_EDITED;
        }
        return GREETING_MESSAGES_NOT_FOUND;
    }

    public String deleteGreeting(int id) {
        Optional<Greeting> greetingsEntity = greetingAppRepository.findById(id);
        if(greetingsEntity.isPresent()){
            greetingAppRepository.delete(greetingsEntity.get());
            return GREETING_MESSAGE_DELETED;
        }
        return GREETING_MESSAGES_NOT_FOUND;
    }
}
