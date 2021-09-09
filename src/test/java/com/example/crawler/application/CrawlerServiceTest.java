package com.example.crawler.application;

import com.example.crawler.dto.CrawlerRequest;
import com.example.crawler.dto.CrawlerResponse;
import com.example.crawler.model.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrawlerServiceTest {
    private CrawlerService crawlerService;

    @BeforeEach
    void setUp() {
        crawlerService = new CrawlerService();
    }

    @Test
    void getData() {
        CrawlerRequest request = new CrawlerRequest("https://www.google.com", Type.HTML, 10);

        final CrawlerResponse actual = crawlerService.getData(request);

        assertThat(actual).isNotNull();
    }
}
