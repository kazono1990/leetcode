package jp.co.kazono.leetcode.LC0088_Merge_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = nums1[tail1] > nums2[tail2] ?
                nums1[tail1--] : nums2[tail2--];
        }
        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        s.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
