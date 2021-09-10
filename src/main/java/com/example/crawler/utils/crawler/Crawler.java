package com.example.crawler.utils.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 크롤러.
 */
public class Crawler {
    private Crawler() {
    }

    /**
     * URL를 통해 데이터를 가져옵니다.
     *
     * @param url 찾고자하는 데이터가 담긴 주소
     * @return 검색된 결과
     */
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
