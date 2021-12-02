package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingAppDTO;
import com.bridgelabz.greetingapp.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetingAppController {

    @Autowired
    GreetingAppService greetingAppService;

    @GetMapping("")
    public GreetingAppDTO getHelloMessageFromDTO(
            @RequestBody GreetingAppDTO greetingAppDTO){
        return greetingAppDTO;
    }

    @GetMapping(value = "/message")
    public String getGreetingMessageOfHelloWorld(){
        return greetingAppService.greet();
    }
    
}
