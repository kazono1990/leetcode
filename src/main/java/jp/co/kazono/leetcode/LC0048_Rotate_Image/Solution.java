package jp.co.kazono.leetcode.LC0048_Rotate_Image;

import java.util.Arrays;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        printMatrix(matrix);

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[n - 1- j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append("|");
            for (int num : matrix[i] ) {
                sb.append(num);
            }
            sb.append("|\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
