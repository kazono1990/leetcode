package jp.co.kazono.leetcode.LC0074_Search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > target) {
                j--;
            }
            else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        System.out.println(s.searchMatrix(matrix, 3));
        System.out.println(s.searchMatrix(matrix, 13));
    }
}
