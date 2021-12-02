package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GreetingAppController {

    @Autowired
    GreetingAppService greetingAppService;

    @GetMapping(value = "/message")
    public String getHelloGoodMorningGreetingMessage() {
        return "Hello Good Morning";
    }
}
