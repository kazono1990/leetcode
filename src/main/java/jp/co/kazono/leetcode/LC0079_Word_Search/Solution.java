package jp.co.kazono.leetcode.LC0079_Word_Search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        // check the searching range.
        // if you can't search '0 <= i < board.length' or '0 <= j < board[j].length', there is no word.
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;
        // if the target char is not correct, then return false.
        if (board[i][j] != word.charAt(index)) return false;
        // if already searched this point, then return false.
        if (visited[i][j]) return false;

        visited[i][j] = true;
        if (search(board, visited, i - 1, j, word, index + 1) ||
            search(board, visited, i + 1, j, word, index + 1) ||
            search(board, visited, i, j - 1, word, index + 1) ||
            search(board, visited, i, j + 1, word, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][] {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        // true
        System.out.println(s.exist(board, "ABCCED"));
        System.out.println(s.exist(board, "SEE"));
        System.out.println(s.exist(board, "ABCESEEDASFC"));
        // false
        System.out.println(s.exist(board, "ABCB"));
    }
}
