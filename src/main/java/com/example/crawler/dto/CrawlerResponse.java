package com.example.crawler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CrawlerResponse {
    private String result;

    public CrawlerResponse(String result) {
        this.result = result;
    }
}
