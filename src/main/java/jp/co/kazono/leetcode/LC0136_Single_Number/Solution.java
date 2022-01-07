package jp.co.kazono.leetcode.LC0136_Single_Number;

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.singleNumber(new int[]{1, 2, 2}));
        // 4
        System.out.println(s.singleNumber(new int[]{4, 1, 2, 1, 2}));
        // 1
        System.out.println(s.singleNumber(new int[]{1}));
    }
}
