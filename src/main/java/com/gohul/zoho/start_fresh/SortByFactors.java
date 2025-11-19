package com.gohul.zoho.start_fresh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortByFactors {


    public static void main(String[] args) {

        System.out.println(sortByFactor(new int[]{5, 11, 10, 20, 9, 16, 23}));
        System.out.println(sortByFactor(new int[]{104, 210, 315, 166, 441, 180}));
        System.out.println(sortByFactor(new int[]{1, 2, 3, 4, 6, 8, 12}));

    }

    public static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) count += 1;   // perfect square
                else count += 2;             // i and n/i
            }
        }
        return count;
    }

    public static String sortByFactor(int[] list){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: list){
            map.put(i, countFactors(i));
        }

        for(int i=1; i<list.length; i++){
            int j = i;

            while(j>=1){
                int f1 = map.get(list[j]);
                int f2 = map.get(list[j-1]);

                // Condition:
                if(f1 > f2) {
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
