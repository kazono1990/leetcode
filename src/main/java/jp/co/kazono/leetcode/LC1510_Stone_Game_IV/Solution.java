package jp.co.kazono.leetcode.LC1510_Stone_Game_IV;

import java.util.Arrays;

public class Solution {

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        System.out.println(Arrays.toString(dp));
        for (int i = 0; i < n + 1; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.winnerSquareGame(1));
        System.out.println(s.winnerSquareGame(2));
        System.out.println(s.winnerSquareGame(4));
    }
}
