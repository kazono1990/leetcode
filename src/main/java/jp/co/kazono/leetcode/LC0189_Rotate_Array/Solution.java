package jp.co.kazono.leetcode.LC0189_Rotate_Array;

import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        // if k is larger than nums.length, then get the k % nums.length
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1); // first step: reverse all num.
        reverse(nums, 0, k - 1); // second step: reverse the first part.
        reverse(nums, k, nums.length - 1); // third step: reverse the second part.
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums_1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        s.rotate(nums_1, 3);
        // [5, 6, 7, 1, 2, 3, 4]
        System.out.println(Arrays.toString(nums_1));

        int[] nums_2 = new int[]{-1, -100, 3, 99};
        s.rotate(nums_2, 2);
        // [3, 99, -1, -100]
        System.out.println(Arrays.toString(nums_2));
    }
}
