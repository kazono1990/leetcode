package jp.co.kazono.leetcode.LC0064_Minimum_Path_Sum;

public class Solution {
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row == 0 && col == 0) {
                    grid[row][col] = grid[row][col];
                } else if (row != 0 && col == 0) {
                    grid[row][col] += grid[row - 1][col];
                } else if (row == 0 && col != 0) {
                    grid[row][col] += grid[row][col - 1];
                } else {
                    grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
                }
            }
        }
        return grid[height - 1][width - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minPathSum(new int[][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        }));
        System.out.println(s.minPathSum(new int[][]{
            {1, 2, 3},
            {4, 5, 6}
        }));
    }
}
