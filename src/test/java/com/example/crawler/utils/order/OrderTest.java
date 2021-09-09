package com.example.crawler.utils.order;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void order() {
        String input = "z0Aaa17bBZA";

        String actual = Order.compare(input);

        assertThat(actual).isEqualTo("A0A1a7aBbZz");
    }
}
