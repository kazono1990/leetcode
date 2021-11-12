package jp.co.kazono.leetcode.LC0122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
