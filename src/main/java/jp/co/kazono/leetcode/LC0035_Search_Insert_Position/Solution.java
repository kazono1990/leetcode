package jp.co.kazono.leetcode.LC0035_Search_Insert_Position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(s.searchInsert(new int[]{1}, 0));
        System.out.println(s.searchInsert(new int[]{1, 3, 5}, 3));
    }
}
