package jp.co.kazono.leetcode.LC1672_Richest_Customer_Wealth;

import java.util.Arrays;

public class Solution {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(max, Arrays.stream(account).sum());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
    }
}
