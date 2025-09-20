package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;   //for generate random unique short code

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public String shortenUrl(String originalUrl){
        String shortCode = UUID.randomUUID().toString().substring(0, 6);

        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(originalUrl);
        mapping.setShortCode(shortCode);
        repository.save(mapping);

        return shortCode;
    }

    public Optional<String> getOriginalUrl(String shortCode){
        return repository.findByShortCode(shortCode)
                .map(UrlMapping::getOriginalUrl);
    }
}
