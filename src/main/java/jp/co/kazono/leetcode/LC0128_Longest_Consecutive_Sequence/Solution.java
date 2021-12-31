package jp.co.kazono.leetcode.LC0128_Longest_Consecutive_Sequence;

import java.util.Arrays;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);

        int length = 1;
        int tmp_length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] - nums[i - 1] == 1) {
                    tmp_length++;
                }
                else {
                    tmp_length = 1;
                }
                length = Math.max(length, tmp_length);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        // 9
        System.out.println(s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        // 3
        System.out.println(s.longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
