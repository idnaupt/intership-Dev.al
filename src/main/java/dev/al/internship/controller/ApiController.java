package dev.al.internship.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/language")
    public String getLanguageGreeting(@RequestParam String lang) {
        Map<String, String> greetings = Map.of(
                "sq", "Përshëndetje!",
                "en", "Hello!",
                "de", "Hallo!"
        );

        return greetings.getOrDefault(lang.toLowerCase(), "Gjuha nuk njihet!");
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot REST API!";
    }
}