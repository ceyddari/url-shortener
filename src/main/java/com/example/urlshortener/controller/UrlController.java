package com.example.urlshortener.controller;

import com.example.urlshortener.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/api/shorten")
    public ResponseEntity<String> shorten(@RequestParam String url) {
        String shortCode = service.shortenUrl(url);
        return ResponseEntity.ok("http://localhost:8080/" + shortCode);
    }

    @GetMapping("/api/shorten")
    public ResponseEntity<String> shortenGet(@RequestParam String url) {
        String shortCode = service.shortenUrl(url);
        return ResponseEntity.ok("http://localhost:8080/" + shortCode);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        return service.getOriginalUrl(shortCode)
                .map(original -> ResponseEntity.status(302)
                        .header("Location", original)
                        .<Void>build())
                .orElse(ResponseEntity.notFound().build());
    }
}