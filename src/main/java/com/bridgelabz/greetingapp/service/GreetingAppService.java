package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingAppDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Purpose : Implement all the methods of GreetingAppController
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 02-12-2021
 */

@Service
public class GreetingAppService {

    private static final String GREETING_MESSAGE_EDITED = "Greeting message of corresponding id is successfully edited.";
    private static final String GREETING_MESSAGES_NOT_FOUND = "Greeting Message of corresponding id is not found.";
    private static final String GREETING_MESSAGE_DELETED = "Greeting Message is deleted successfully.";

    @Autowired
    GreetingAppRepository greetingAppRepository;

    /**
     * Purpose : To get the greeting message
     *
     * @return greeting message
     */
    public String greet() {
        return "Hello World";
    }

    /**
     * Purpose : To save the greeting message to the database
     *
     * @param greetingAppDTO defines greeting data from client
     * @return greeting message
     */
    public Greeting saveGreeting(GreetingAppDTO greetingAppDTO) {
        Greeting greeting = new Greeting();
        greeting.setMessage(greetingAppDTO.getMessage());
        return greetingAppRepository.save(greeting);
    }

    /**
     * Purpose : To find the greeting message by id
     *
     * @param id defines id of the client
     * @return greeting message
     */
    public Greeting getGreetingById(int id) {
        Optional<Greeting> greetById = greetingAppRepository.findById(id);
        return greetById.orElse(null);
    }

    /**
     * Purpose : To list all the greeting messages store in the greeting repository
     *
     * @return the list of all greeting messages
     */
    public List<Greeting> getAll() {
        return greetingAppRepository.findAll();
    }

    /**
     * Purpose : To edit the available greeting in the database
     *
     * @param id defines the id
     * @param greetingAppDTO greetingAppDTO greeting data from client
     * @return greeting message status is edited or not
     */
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

    /**
     * Purpose : To delete particular greeting message
     *
     * @param id defines the unique id
     * @return greeting message status is deleted or not
     */
    public String deleteGreeting(int id) {
        Optional<Greeting> greetingsEntity = greetingAppRepository.findById(id);
        if(greetingsEntity.isPresent()){
            greetingAppRepository.delete(greetingsEntity.get());
            return GREETING_MESSAGE_DELETED;
        }
        return GREETING_MESSAGES_NOT_FOUND;
    }
}
