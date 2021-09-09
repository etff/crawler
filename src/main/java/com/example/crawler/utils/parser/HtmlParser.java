package com.example.crawler.utils.parser;

public class HtmlParser {
    private static final String REMOVE_HTML = "<([^>]+)>";
    private static final String ACCEPT_NUMBER_ENGLISH = "[^a-zA-Z0-9]";

    private HtmlParser() {
    }

    public static String parser(String text) {
        return text.replaceAll(REMOVE_HTML, "")
                .replaceAll(ACCEPT_NUMBER_ENGLISH, "")
                .trim();
    }
}
