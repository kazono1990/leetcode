package jp.co.kazono.leetcode.LC0075_Sort_Colors;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) return;

        int left = 0;
        int right = len - 1;
        int current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            }
            else if (nums[current] == 1) {
                current++;
            }
            else {
                swap(nums, right, current);
                right--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[]{2, 0, 2, 1, 1, 0};
        s.sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
