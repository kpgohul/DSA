package com.gohul.zoho;

import java.util.*;

public class RemoveFragment {

    public static void main(String[] args) {

        String s1 = "I believe that hard work brings success";
        String s2 = "They also believe that hard work creates opportunities";
        String s3 = "We all believe that hard work matters the most";

        int fragmentSize = 3;

        String[] arr = {s1, s2, s3};

        List<Integer> list = getSpaceIndexes(arr[0]);
        list.add(0, 0); // start
        list.add(arr[0].length()); // end

        int st = 0;
        while (st + fragmentSize <= list.size() - 2) {
            int startIndex = list.get(st);
            int endIndex = list.get(st + fragmentSize + 1);
            String fragment = arr[0].substring(startIndex, endIndex).trim();

            boolean isCommon = true;
            for (String str : arr) {
                if (!str.contains(fragment)) {
                    isCommon = false;
                    break;
                }
            }

            if (isCommon) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = arr[i].replace(fragment, "").replaceAll("\\s+", " ").trim();
                }
            }

            st++;
        }

        System.out.println("\nAfter processing:");
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static List<Integer> getSpaceIndexes(String str) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') list.add(i);
        }
        return list;
    }
}
