package jp.co.kazono.leetcode.LC0016_3Sum_Closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = 0;
        int curr = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                else if (sum < target) {
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
                else if (sum > target) {
                    while(left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                }
                int diff = Math.abs(sum - target);
                if (diff < curr) {
                    curr = diff;
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(s.threeSumClosest(new int[]{1, 1, -1, -1, 3}, 3));
        System.out.println(s.threeSumClosest(new int[]{1, 1, 1, 0}, -100));
        System.out.println(s.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }
}
