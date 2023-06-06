package com.anagramservice.controller;

import com.anagramservice.model.AnagramRequest;
import com.anagramservice.service.AnagramStringService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnagramController {

    @Autowired
    private final AnagramStringService anagramStringService;

    private final ObjectMapper objectMapper;
    public AnagramController(AnagramStringService anagramStringService, ObjectMapper objectMapper) {
        this.anagramStringService = anagramStringService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/anagrams")
    public ResponseEntity<String> checkAnagrams(@RequestBody String jsonPayload) {
        try {
            AnagramRequest request = objectMapper.readValue(jsonPayload, AnagramRequest.class);
            String firstWord = request.getFirstWord();
            String secondWord = request.getSecondWord();
            String result = anagramStringService.isAnagram(firstWord, secondWord);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON payload");
        }
    }
}
