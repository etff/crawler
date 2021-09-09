package com.example.crawler.utils.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HtmlParserTest {

    @Test
    void remove_html() {
        final String givenInput = ""
                + "<html>"
                + "<head>"
                + "<script src=\"/sample.js\">alert('hi');</script>"
                + "</head>"
                + "</body>"
                + "<div>hi...</div>"
                + "</body>"
                + "</html>";
        assertThat(HtmlParser.parser(givenInput)).isEqualTo("alerthihi");
    }

    @Test
    void remove_korean() {
        final String givenInput = "가나다라abc";
        assertThat(HtmlParser.parser(givenInput)).isEqualTo("abc");
    }

    @Test
    void accept_english_and_number() {
        String givenInput = "*가1a";

        assertThat(HtmlParser.parser(givenInput)).isEqualTo("1a");
    }
}
