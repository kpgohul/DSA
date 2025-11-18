package com.gohul.zoho.start_fresh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortByFrequency {

    public static void main(String[] args) {

        System.out.println(findOut(new int[]{1, 5, 2, 1, 2, 3, 5, 5, 2, 1}));
        System.out.println(findOut(new int[]{4, 4, 4, 2, 2, 9, 9, 9}));
    }

    public static String findOut(int[] list){
        Map<Integer,Integer> map = new HashMap<>();

        // Count frequencies
        for(int i: list)
            map.put(i, map.getOrDefault(i, 0) + 1);

        // Insertion Sort with custom condition
        for(int i=1; i<list.length; i++){
            int j = i;

            while(j>=1){
                int f1 = map.get(list[j]);
                int f2 = map.get(list[j-1]);

                // Condition:
                if(f1 > f2 || (f1 == f2 && list[j] < list[j-1])) {
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                    j--;
                } else break;
            }
        }

        return Arrays.toString(list);
    }

}
