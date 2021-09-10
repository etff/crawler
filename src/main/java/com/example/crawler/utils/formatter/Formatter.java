package com.example.crawler.utils.formatter;

import com.example.crawler.dto.CrawlerResponse;

import java.util.Objects;

public class Formatter {
    private static final String BLANK_NOT_ALLOWED = "빈값이 들어올 수 없습니다.";
    private static final String MINIMUM_UNIT_VALUE = "0보다 작을 수 없습니다.";

    private Formatter() {
    }

    public static CrawlerResponse changeFormat(String text, int unit) {
        validateParameters(text, unit);
        if (text.length() < unit) {
            return new CrawlerResponse("", text);
        }

        final int quotient = getQuotient(text, unit);
        final String subString = getSubstring(text, unit, quotient);
        final String remains = getRemains(text, unit, quotient);
        return new CrawlerResponse(appendText(unit, subString), remains);
    }

    private static String getRemains(String text, int unit, int quotient) {
        return text.substring(quotient * unit);
    }

    private static String getSubstring(String text, int unit, int quotient) {
        return text.substring(0, (quotient * unit));
    }

    private static int getQuotient(String text, int unit) {
        return text.length() / unit;
    }

    private static String appendText(int unit, String subString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subString.length(); i++) {
            sb.append(subString.charAt(i));
            int endOfText = subString.length() - 1;
            if (i % unit == unit - 1 && i != endOfText) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private static void validateParameters(String text, int unit) {
        if (Objects.isNull(text) || text.isEmpty()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED);
        }
        if (unit < 0) {
            throw new IllegalArgumentException(MINIMUM_UNIT_VALUE);
        }
    }
}
