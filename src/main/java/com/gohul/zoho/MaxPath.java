package com.gohul.zoho;

public class MaxPath {

    public static void main(String[] args) {
        int n = 4; // number of rows

        int[][] arr = {
                {3},
                {7, 4},
                {2, 4, 6},
                {8, 5, 9, 3}
        };

        System.out.println(findOut1(0, 0,  arr));
    }

    public static int findOut1(int i, int j,  int[][] list){

        if(i == list.length -1) return list[i][j];

        int bottom = list[i][j] + findOut1(i+1, j, list);
        int diagonal = list[i][j] + findOut1(i+1, j+1, list);

        return Math.max(bottom, diagonal);
    }

}
