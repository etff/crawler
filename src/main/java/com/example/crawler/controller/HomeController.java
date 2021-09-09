package com.example.crawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    /**
     * URL 입력폼 제공 및 결과 출력 Page.
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
