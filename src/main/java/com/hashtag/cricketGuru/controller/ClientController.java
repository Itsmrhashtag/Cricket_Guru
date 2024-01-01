package com.hashtag.cricketGuru.controller;

import com.hashtag.cricketGuru.services.JpaClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController // Or @Service, @Component, etc., depending on your use case
public class ClientController {

    private final JpaClientDetailsService clientDetailsService;

    @Autowired
    public ClientController(JpaClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    @PostMapping("/addClient")
    public ResponseEntity<String> addClient() {
        try {
            // Example: Adding new client details using the service method
            clientDetailsService.addClientDetails(
                    "hashtag",
                    "hashtag",
                    Arrays.asList("read", "write"),
                    Arrays.asList("password", "refresh_token"),
                    3600, // Access token validity in seconds
                    7200  // Refresh token validity in seconds
            );
            return ResponseEntity.ok("Client added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add client: " + e.getMessage());
        }
    }
}
