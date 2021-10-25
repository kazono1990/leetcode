package jp.co.kazono.leetcode.LC0026_Remove_Duplicates_from_Sorted_Array;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i == 0 || num > nums[i - 1]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
