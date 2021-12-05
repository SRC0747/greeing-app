package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingAppDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Purpose : Demonstrate various HTTP request methods
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 02-12-2021
 */

@RestController
public class GreetingAppController {

    @Autowired
    GreetingAppService greetingAppService;

    /**
     * Purpose : To get greeting message from client
     *
     * @return greeting message
     */
    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome To This Server!!!";
    }

    /**
     * Purpose : To get greeting message by passing name using PathVariable
     *
     * @param name defines the PathVariable which is passed
     * @return welcome greeting message
     */
    @GetMapping("/greeting2/{name}")
    public String greetingUsingGetMethod(
            @PathVariable String name
    ) {
        return "Welcome " + name + " and have a nice day!";
    }

    /**
     * Purpose : To put the greeting message by passing StringName as RequestParam
     *
     * @param name defines the RequestParam which is passed
     * @return welcome greeting message
     */
    @PutMapping("/greeting3")
    public String greetingUsingPutMethod(
            @RequestParam String name
    ) {
        return "Welcome " + name + " and have a nice day!";
    }

    /**
     * Purpose : To get greeting message from client server
     *
     * @return greeting message
     */
    @GetMapping(value = "/message")
    public String getGreetingMessageOfHelloWorld() {
        return greetingAppService.greet();
    }

    /**
     * Purpose : To get greeting message from client by passing firstName and lastName as RequestParam
     *
     * @param firstName defines firstName of the client
     * @param lastName defines lastName of the client
     * @return greeting message mentioning name
     */
    @GetMapping(value = "/message1")
    public String getGreetingMessageUsingName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        return "Hello : " + firstName + " " + lastName;
    }

    /**
     * Purpose : To add the greeting message corresponding to the particular id of the client
     *
     * @param message defines the greeting message
     * @return the greeting message according to the particular id
     */
    @PostMapping(value = "/save")
    public Greeting saveGreetingMessage(@RequestBody GreetingAppDTO message) {
        return greetingAppService.saveGreeting(message);
    }

    /**
     * Purpose : To find the greeting message by id used as PathVariable
     *
     * @param id defines the id of the client
     * @return greeting message corresponding to the id
     */
    @GetMapping("/findById/{id}")
    public Greeting getGreetingById(@PathVariable int id) {
        return greetingAppService.getGreetingById(id);
    }

    /**
     * Purpose : To get all the greeting messages registered to the id of the clients
     *
     * @return greeting message
     */
    @GetMapping(value = "/all")
    public List<Greeting> get(){
        return greetingAppService.getAll();
    }

    /**
     * Purpose : To edit the greeting message corresponding to the id used as PathVariable
     *
     * @param id defines the id of the client
     * @param message defines the greeting message
     * @return edit the old message with new greeting message of corresponding id
     */
    @PutMapping(value = "/save/{id}")
    public String editGreeting(
            @PathVariable int id,
            @RequestBody GreetingAppDTO message){
        return  greetingAppService.editGreeting(id, message);
    }

    /**
     * Purpose : To delete the greeting message by corresponding id using RequestParam
     *
     * @param id defines the id of the client
     */
    @DeleteMapping(value = "/delete")
    public void deleteGreeting(
            @RequestParam int id){
        greetingAppService.deleteGreeting(id);
    }
}
