package jp.co.kazono.leetcode.LC0054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int n = matrix.length, m = matrix[0].length;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;

        while (res.size() < n * m) {
            for (int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[left][j]);

            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                res.add(matrix[i][right]);

            for (int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);

            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                res.add(matrix[i][left]);

            up++;
            down--;
            left++;
            right--;
        }

        return res;
    }

    public void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i : list) {
            sb.append(i + " ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.spiralOrder(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}}));
        s.printList(s.spiralOrder(new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}}));
    }
}
