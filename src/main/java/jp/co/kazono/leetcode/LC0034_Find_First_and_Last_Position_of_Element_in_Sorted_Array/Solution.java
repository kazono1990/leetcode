package jp.co.kazono.leetcode.LC0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            if (nums[middle] == target && nums[low] == nums[high]) {
                return new int[]{low, high};
            } else if (nums[middle] == target && nums[low] < target) {
                low++;
            } else if (nums[middle] == target && target < nums[high]) {
                high--;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle -1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
