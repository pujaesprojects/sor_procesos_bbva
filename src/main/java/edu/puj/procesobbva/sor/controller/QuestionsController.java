package edu.puj.procesobbva.sor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    @GetMapping
    public ResponseEntity<Map<String, String>> getQuestions() {
        Map<String, String> response = new HashMap<>();
        response.put("Hello", "Word");
        return ResponseEntity.ok(response);
    }
}
