package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingAppDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingAppController {

    @Autowired
    GreetingAppService greetingAppService;

    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome To This Server!!!";
    }

    @GetMapping("/greeting2/{name}")
    public String greetingUsingGetMethod(
            @PathVariable String name
    ) {
        return "Welcome " + name + " and have a nice day!";
    }

    @PutMapping("/greeting3")
    public String greetingUsingPutMethod(
            @RequestParam String name
    ) {
        return "Welcome " + name + " and have a nice day!";
    }

    @GetMapping(value = "/message")
    public String getGreetingMessageOfHelloWorld() {
        return greetingAppService.greet();
    }

    @GetMapping(value = "/message1")
    public String getGreetingMessageUsingName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        return "Hello : " + firstName + " " + lastName;
    }

    @PostMapping(value = "/save")
    public Greeting saveGreetingMessage(@RequestBody GreetingAppDTO message) {
        return greetingAppService.saveGreeting(message);
    }

    @GetMapping("/findById/{id}")
    public Greeting getGreetingById(@PathVariable int id) {
        return greetingAppService.getGreetingById(id);
    }

    @GetMapping(value = "/all")
    public List<Greeting> get(){
        return greetingAppService.getAll();
    }

    @PutMapping(value = "/save/{id}")
    public String editGreeting(
            @PathVariable int id,
            @RequestBody GreetingAppDTO message){
        return  greetingAppService.editGreeting(id, message);
    }

    @DeleteMapping(value = "/delete")
    public void deleteGreeting(
            @RequestParam int id){
        greetingAppService.deleteGreeting(id);
    }
}
