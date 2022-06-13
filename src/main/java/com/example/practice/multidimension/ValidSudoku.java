package com.example.practice.multidimension;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        for(int k = 0; k < 9; k+=3) {
            for(int c = 0; c < 9        ; c+=3) {
                Set<Character> block = new HashSet<>(9);
                for (int i = k; i < k + 3; i++) {
                    for (int j = c; j < c+3; j++) {
                        if (board[i][j] != '.') {
                            if (!block.add(board[i][j])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        for(int x = 0; x < 9; x++) {
            Set<Character> columns = new HashSet<>(9);
            for(int y = 0; y < 9; y++) {
                if (board[y][x] != '.') {
                    if(!columns.add(board[y][x])) {
                        return false;
                    }
                }
            }
        }

        for(int x = 0; x < 9; x++) {
            Set<Character> rows = new HashSet<>(9);
            for(int y = 0; y < 9; y++) {
                if (board[x][y] != '.') {
                    if(!rows.add(board[x][y])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char [][] board = {{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        Assert.isTrue(isValidSudoku(board), "Valid Sudoku");
        
        char [][] board2 =
        {{'7','.','.','.','4','.','.','.','.'},
        {'.','.','.','8','6','5','.','.','.'},
        {'.','1','.','2','.','.','.','.','.'},
        {'.','.','.','.','.','9','.','.','.'},
        {'.','.','.','.','5','.','5','.','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.','.'}};

        Assert.isTrue(!isValidSudoku(board2), "In-valid Sudoku");
    }

}
