package dev.al.internship.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class klasaController {
    @PostMapping("/language")
    public String respondToLanguage(@RequestBody String language) {
        Map<String, String> greetings = Map.of(
                "sq", "Përshëndetje!",
                "en", "Hello!",
                "de", "Hallo!"
        );

        return greetings.getOrDefault(language.toLowerCase(), "Gjuha nuk njihet!");
    }

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Përshëndetje nga GET!";
    }

    @GetMapping("/message")
    public String getMessage() {
        return "Mesazhi nga controlleri i ri!";
    }
}