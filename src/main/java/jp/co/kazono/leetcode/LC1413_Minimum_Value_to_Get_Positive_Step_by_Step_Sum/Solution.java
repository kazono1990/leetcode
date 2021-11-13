package jp.co.kazono.leetcode.LC1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum;

public class Solution {
    public int minStartValue(int[] nums) {
        int minValue = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
            minValue = Math.min(minValue, total);
        }
        return -minValue + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(s.minStartValue(new int[]{1, 2}));
        System.out.println(s.minStartValue(new int[]{1, -2, -3}));
    }
}
