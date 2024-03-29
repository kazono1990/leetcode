package jp.co.kazono.leetcode.LC0560_Subarray_Sum_Equals_K;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraySum(new int[]{1,1,1}, 2));
    }
}
