package jp.co.kazono.leetcode.LC0063_Unique_Paths_II;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        // if the starting cell is obstacle, there are no path to goal.
        if (obstacleGrid[0][0] == 1) return 0;

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first columns.
        for (int i = 1; i < height; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first rows.
        for (int j = 1; j < width; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
        }

        // Starting from obstacleGrid[1][1] fill up the value.
        // Number of ways of reaching obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
        // -> above + left = No. of way
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
                else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[height-1][width-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input1 = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int[][] input2 = new int[][]{
            {0, 1},
            {0, 0}
        };

        System.out.println(s.uniquePathsWithObstacles(input1));
        System.out.println(s.uniquePathsWithObstacles(input2));
    }
}
