package com.gohul.zoho.start_fresh;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortMatrixDiagonal {

    public static void main(String[] args) {

        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };

        System.out.println("Original Matrix:");
        printMatrix(mat);

        sort(mat);

        System.out.println("\nAfter Diagonal Sort:");
        printMatrix(mat);


    }

    public static void sort(int[][] list){

        int row = list.length;
        int col = list[0].length;

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=0; i<list.length; i++){
            for(int j=0; j<list[0].length; j++){
                int key = i-j;
                map.putIfAbsent(key, new PriorityQueue<>());
                map.get(key).offer(list[i][j]);
            }
        }

        for(int i=0; i<list.length; i++){
            for(int j=0; j<list[0].length; j++){
                int key = i-j;
                list[i][j] = map.get(key).poll();
            }
        }

    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
