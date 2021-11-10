package jp.co.kazono.leetcode.LC0053_Maximum_Subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = max;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(s.maxSubArray(new int[]{1}));
        System.out.println(s.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
