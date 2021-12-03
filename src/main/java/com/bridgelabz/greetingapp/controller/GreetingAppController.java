package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingAppDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.GreetingAppService;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/hello")
public class GreetingAppController {

    @Autowired
    GreetingAppService greetingAppService;
    private IGreetingService iGreetingService;

    @GetMapping("")
    public GreetingAppDTO getHelloMessageFromDTO(
            @RequestBody GreetingAppDTO greetingAppDTO) {
        return greetingAppDTO;
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

    @PostMapping(value = "/fullName")
    public Greeting addGreetingMessage(@RequestBody User user) {
        return iGreetingService.addGreeting(user);
    }

    @GetMapping(value = "/all")
    public List<Greeting> getAll(){
        return iGreetingService.getAll();
    }

    @PutMapping(value = "/editGreeting/{id}")
    public Optional<Greeting> editGreetingById(
            @PathVariable("id") int id,
            @RequestParam(value = "name") String name) {
        return iGreetingService.editGreetingById(id, name);
    }
}
