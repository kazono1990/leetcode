package jp.co.kazono.leetcode.LC0080_Rmove_Duplicates_from_Sorted_Array_II;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}
