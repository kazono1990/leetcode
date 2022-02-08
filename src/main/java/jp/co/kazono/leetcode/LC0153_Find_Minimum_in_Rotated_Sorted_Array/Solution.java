package jp.co.kazono.leetcode.LC0153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {

    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;
        // e.g. [0, 1, 2, 3, 4, 5]
        if (nums[0] < nums[right]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            // e.g. [3, 4, 5, 6, 0, 1, 2]
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid +1];
            }

            // e.g. [4, 5, 6, 0, 1, 2, 3]
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
               left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
