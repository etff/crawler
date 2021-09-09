package com.example.crawler.controller.api;

import com.example.crawler.dto.CrawlerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crawler")
public class CrawlerController {

    @PostMapping
    public ResponseEntity<Void> getCrawlerData(@RequestBody CrawlerRequest dto) {
        return null;
    }
}
