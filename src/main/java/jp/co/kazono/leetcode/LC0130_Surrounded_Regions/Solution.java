package jp.co.kazono.leetcode.LC0130_Surrounded_Regions;

import java.util.Arrays;

public class Solution {

    public void solve(char[][] board) {
        if (board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // check the periphery of board.
                // if there are 'O', call dfs() to check the line which is directly connected by it.
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
             if (board[i][j] == 'O') board[i][j] = 'X';
             else if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O') {
            return;
        }
        // System.out.println("----------");
        // System.out.println("(i, j) = (" + i + ", " + j + ")");
        board[i][j] = '-';
        // printBoard(board);

        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }

    private void printBoard(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (char[] line : board) {
            sb.append(Arrays.toString(line)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][] {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        s.printBoard(board);
        System.out.println("----------");
        s.solve(board);
        s.printBoard(board);
    }
}
