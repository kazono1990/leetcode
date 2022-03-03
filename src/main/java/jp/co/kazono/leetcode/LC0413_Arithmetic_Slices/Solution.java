package jp.co.kazono.leetcode.LC0413_Arithmetic_Slices;

public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int sum = 0, curr = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
