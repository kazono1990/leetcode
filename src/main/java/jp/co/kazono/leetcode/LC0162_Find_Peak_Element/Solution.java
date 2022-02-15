package jp.co.kazono.leetcode.LC0162_Find_Peak_Element;

public class Solution {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2 (index of 3)
        System.out.println(s.findPeakElement(new int[]{1, 2, 3, 1}));
        // 5 (index of 6)
        System.out.println(s.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
