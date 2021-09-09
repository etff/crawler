package com.example.crawler.application;

import com.example.crawler.dto.CrawlerRequest;
import com.example.crawler.dto.CrawlerResponse;
import com.example.crawler.model.Type;
import com.example.crawler.utils.crawler.Crawler;
import com.example.crawler.utils.parser.HtmlParser;
import org.springframework.stereotype.Service;

@Service
public class CrawlerService {

    public CrawlerResponse getData(CrawlerRequest dto) {
        String foundData = Crawler.getDataFromUrl(dto.getUrl());
        if (dto.getType().equals(Type.HTML)) {
            return new CrawlerResponse(HtmlParser.parser(foundData));
        }
        return new CrawlerResponse(foundData);
    }
}
