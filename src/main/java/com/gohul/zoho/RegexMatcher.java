package com.gohul.zoho;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {

    public static void main(String[] args) {
        String text = "abcbbcabb";
        String pattern = "cb*cab+";

        String result = findFirstMatch(text, pattern);
        System.out.println(result != null ? result : "No Match");
    }

    public static String findFirstMatch(String text, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

}
