package com.bridgelabz.greetingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GreetingAppController {

    @GetMapping(value = "/message")
    public String getHelloGoodMorningGreetingMessage() {
        return "Hello Good Morning";
    }
}
