package com.gohul.zoho.start_fresh;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountTriangle {

    public static void main(String[] args) {

        int[] list = {4, 6, 3, 7};

//        System.out.println(findOut(list, new LinkedList<>(), 0));

    }

    //wrong
    public static int findOut(int[] list, List<Integer> assist, int start){

        if(assist.size() == 3){
            if(assist.getFirst() + assist.get(1) > assist.getLast())
                return 1;
            return 0;
        }

        int ans = 0;

        for(int i=start; i<list.length; i++){

            if(!assist.contains(list[i])){
                assist.add(list[i]);
                ans+=findOut(list, assist, i+1);
                assist.removeLast();
            }

        }
        return ans;
    }


    public static int countTriangle(int[] list){
        if (list.length < 3) return 0;

        Arrays.sort(list);

        int n = list.length;
        int count = 0;

        for(int high = n - 1; high>=2; high--){

            int mid = high - 1;
            int low = 0;

            while(low < mid){
                if(list[low] + list[mid] > list[high]){
                    count += mid - low;
                    mid--;
                }
                else low++;
            }
        }

        return count;
    }

}
