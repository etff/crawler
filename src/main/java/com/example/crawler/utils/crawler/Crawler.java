package com.example.crawler.utils.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler {
    private Crawler() {
    }

    public static String getDataFromUrl(String url) {
        Document document;
        try {
            document = Jsoup.connect(url).get();
            return document.html().trim();
        } catch (Exception e) {
            e.getMessage();
        }
        return "";
    }
}
