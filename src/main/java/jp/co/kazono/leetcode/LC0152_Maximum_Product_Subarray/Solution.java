package jp.co.kazono.leetcode.LC0152_Maximum_Product_Subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 1) return nums[0];

        int max = nums[0];
        int min = nums[0];
        int res = max;

        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            if (max > res) {
                res = max;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
