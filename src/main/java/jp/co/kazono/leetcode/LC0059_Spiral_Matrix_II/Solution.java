package jp.co.kazono.leetcode.LC0059_Spiral_Matrix_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int colStart = 0, colEnd = n - 1;
        int rowStart = 0, rowEnd = n - 1;

        while (colStart <= colEnd && rowStart <= rowEnd) {
            // top
            for (int j = colStart; j <= colEnd; j++) {
                result[rowStart][j] = count++;
            }

            // right side
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                result[i][colEnd] = count++;
            }

            // bottom
            for (int j = colEnd - 1; colStart <= j; j--) {
                result[rowEnd][j] = count++;
            }

            // left side
            for (int i = rowEnd - 1; rowStart < i; i--) {
                result[i][colStart] = count++;
            }
            colStart++; colEnd--;
            rowStart++; rowEnd--;
        }

        return result;
    }

    public void printList(int[][] intervals) {
        for (int[] interval : intervals) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            for (int num : interval) {
                sb.append(num + " ");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.generateMatrix(3));
    }
}
