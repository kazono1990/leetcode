package jp.co.kazono.leetcode.LC0081_Search_in_Rotated_Sorted_Array_II;

public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return true;

            // right part is sorted, or left part is unsorted.
            if (nums[middle] < nums[right] || nums[middle] < nums[left]) {
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            // left part is sorted, or right part is unsorted.
            else if (nums[middle] > nums[left] || nums[middle] > nums[right]) {
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            // if nums[left] == nums[middle] == nums[right]
            // remove duplicated number.
            else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}
