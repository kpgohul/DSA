package com.gohul.problem;

import java.util.Arrays;

public class NKnight {

    public static void main(String[] args) {
        int knightCount = 8;
        char[][] board = new char[4][4];
        for(char[] t: board) Arrays.fill(t, 'O');
        solve(board, 0, 0, knightCount);
    }


    public static void solve(char[][] board, int row, int col, int count){
        if(count == 0){
            Arrays.stream(board).forEach(r -> System.out.println(Arrays.toString(r)));
            System.out.println();
        }
        if(row == board.length) return;

        int nxtRowVal = (col == board[0].length - 1)? row + 1 : row;
        int nctColVal = (col == board[0].length - 1)? 0 : col + 1;

        if(isSafe(board, row, col)){
            board[row][col] = 'K';
            solve(board, nxtRowVal, nctColVal, count - 1);
            board[row][col] = 'O';
        }
        solve(board, nxtRowVal, nctColVal, count);

    }

    public static boolean isSafe(char[][] board, int row, int col){

        int tempRow = row - 1;
        int tempCol = col -2;
        if(isIn(board, tempRow, tempCol) && board[tempRow][tempCol] == 'K')
            return false;
        tempCol = col + 2;
        if(isIn(board, tempRow, tempCol) && board[tempRow][tempCol] == 'K')
            return false;
        tempRow = row - 2;
        tempCol = col - 1;
        if(isIn(board, tempRow, tempCol) && board[tempRow][tempCol] == 'K')
            return false;
        tempRow = row - 2;
        tempCol = col + 1;
        if(isIn(board, tempRow, tempCol) && board[tempRow][tempCol] == 'K')
            return false;
        return true;

    }

    public static boolean isIn( char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        return true;
    }
}
