package com.gohul.problem;

import java.util.Arrays;

public class NQueen {

    public static void main(String[] args) {

        char[][] board = new char[8][8];
        for(char[] t: board) Arrays.fill(t, ' ');
//        System.out.println(placeQueens1(board, 0));
        placeQueens2(board, 0);


    }

    public static boolean placeQueens1(char[][] board, int row){

        if(row == board.length){
            Arrays.stream(board)
                    .forEach(r -> System.out.println(Arrays.toString(r)));
            return true;
        }

        for(int i=0; i<board[0].length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                if(placeQueens1(board, row + 1)) return true;
                board[row][i] = ' ';
            }
        }
        return false;
    }

    public static void placeQueens2(char[][] board, int row){

        if(row == board.length){
            Arrays.stream(board)
                    .forEach(r -> System.out.println(Arrays.toString(r)));
            System.out.println();
            return;
        }

        for(int i=0; i<board[0].length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                placeQueens2(board, row + 1);
                board[row][i] = ' ';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        for(int i=0;i<=row-1;i++){
            if(isIn(i, col, board) && board[i][col] == 'Q') return false;
        }
        for(int i=row-1, j=col-1;isIn(i,j,board);i--,j--){
            if(isIn(i, j, board) && board[i][j] == 'Q') return false;
        }
        for(int i=row-1, j=col+1;isIn(i,j,board);i--,j++){
            if(isIn(i, j, board) && board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static boolean isIn(int row, int col, char[][] board){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        return true;
    }
}
