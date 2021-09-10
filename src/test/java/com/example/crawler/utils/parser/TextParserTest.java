package com.example.crawler.utils.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextParserTest {

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
        assertThat(TextParser.parseHTML(givenInput)).isEqualTo("alerthihi");
    }

    @Test
    void remove_html_korean() {
        final String givenInput = "<html><body>가나다라abc</body></html>";
        assertThat(TextParser.parseHTML(givenInput)).isEqualTo("abc");
    }

    @Test
    void accept_english_and_number() {
        String givenInput = "*가1a";

        assertThat(TextParser.parseHTML(givenInput)).isEqualTo("1a");
    }

    @Test
    void remove_text_korean() {
        final String givenInput = "가나다라abc";
        assertThat(TextParser.parseText(givenInput)).isEqualTo("abc");
    }
}
