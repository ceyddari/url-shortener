package com.example.urlshortener.repository;

import com.example.urlshortener.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlMapping, Long> {

    @Query("SELECT u FROM UrlMapping u WHERE u.shortCode = :shortCode")
    Optional<UrlMapping> findByShortCode(@Param("shortCode") String shortCode);
}
