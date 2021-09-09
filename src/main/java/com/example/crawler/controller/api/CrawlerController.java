package com.example.crawler.controller.api;

import com.example.crawler.application.CrawlerService;
import com.example.crawler.dto.CrawlerRequest;
import com.example.crawler.dto.CrawlerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/crawler")
public class CrawlerController {
    private final CrawlerService crawlerService;

    @PostMapping
    public ResponseEntity<CrawlerResponse> getCrawlerData(@RequestBody CrawlerRequest dto) {
        CrawlerResponse data = crawlerService.getData(dto);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
}
