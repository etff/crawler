package com.example.crawler.application;

import com.example.crawler.dto.CrawlerRequest;
import com.example.crawler.dto.CrawlerResponse;
import com.example.crawler.model.Type;
import com.example.crawler.utils.crawler.Crawler;
import com.example.crawler.utils.formatter.Formatter;
import com.example.crawler.utils.order.Order;
import com.example.crawler.utils.parser.TextParser;
import org.springframework.stereotype.Service;

@Service
public class CrawlerService {

    public CrawlerResponse getData(CrawlerRequest dto) {
        final String foundData = Crawler.getDataFromUrl(dto.getUrl());
        if (dto.getType().equals(Type.HTML)) {
            final String parsedText = TextParser.parseHTML(foundData);
            return Formatter.changeFormat(Order.compare(parsedText), dto.getUnit());
        }
        final String parsedText = TextParser.parseText(foundData);
        return Formatter.changeFormat(Order.compare(parsedText), dto.getUnit());
    }
}
