package jp.co.kazono.leetcode.LC0036_Valid_Sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // '1' in row 2 is encoded as '(1)2'.
        // '1' in column 2 is encoded as '2(1)'.
        // '1' in the top-left block is encoded as '0(1)2'.
        Set numbers = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    String number = "(" + board[i][j] + ")";
                    if (!numbers.add(number + i) || !numbers.add(j + number) || !numbers.add(i / 3 + number + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(s.isValidSudoku(board));
    }
}
