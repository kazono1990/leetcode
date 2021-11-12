package jp.co.kazono.leetcode.LC0121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null | prices.length <= 1) return 0;

        int tmpProfit = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            tmpProfit = Math.max(0, tmpProfit + prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxProfit, tmpProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
