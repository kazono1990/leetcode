package jp.co.kazono.leetcode.LC0073_Set_Matrix_Zeroes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; // Number of Rows
        int n = matrix[0].length; // Number of Columns
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
         Solution s = new Solution();
         int[][] matrix = new int[][]{
             {1, 1, 1},
             {1, 0, 1},
             {1, 1, 1}
         };
         s.setZeroes(matrix);
         for (int[] line : matrix) {
             System.out.println(Arrays.toString(line));
         }
    }
}
