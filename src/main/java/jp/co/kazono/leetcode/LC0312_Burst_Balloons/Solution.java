package jp.co.kazono.leetcode.LC0312_Burst_Balloons;

import java.util.Arrays;

public class Solution {

    public int maxCoins(int[] nums) {
        int[] _nums = new int[nums.length + 2];
        int n = 1;
        // initialize
        for (int num : nums) {
            if (num > 0) _nums[n++] = num;
        }
        _nums[0] = _nums[n++] = 1;
        System.out.println(Arrays.toString(_nums));

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                        _nums[left] * _nums[i] * _nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
