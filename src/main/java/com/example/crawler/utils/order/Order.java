package com.example.crawler.utils.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Order {

    public static String compare(String input) {
        Queue<Character> queue = getSortNumbers(input);
        List<String> collect = sortText(input);
        return appendText(queue, collect);
    }

    private static List<String> sortText(String input) {
        return Arrays.stream(input.split(""))
                .filter(v -> Character.isLetter(v.charAt(0)))
                .sorted((o1, o2) -> {
                    int res = o1.compareToIgnoreCase(o2);
                    return (res == 0) ? o1.compareTo(o2) : res;
                }).collect(Collectors.toList());
    }

    private static Queue<Character> getSortNumbers(String input) {
        List<Character> numbers = new ArrayList();
        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.add(c);
            }
        }
        Collections.sort(numbers);
        return new LinkedList<>(numbers);
    }

    private static String appendText(Queue<Character> queue, List<String> collect) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < collect.size(); i++) {
            output.append(collect.get(i));
            if (!queue.isEmpty()) {
                output.append(queue.poll());
            }
        }
        return new String(output);
    }
}
