package com.example.crawler.utils.order;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void order() {
        String input = "z0Aaa17bBZA";
        assertThat(Order.compare(input)).isEqualTo("A0A1a7aBbZz");
    }
}
