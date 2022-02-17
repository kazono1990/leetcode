package jp.co.kazono.leetcode.LC0169_Majority_Element;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int sum = count.getOrDefault(nums[i], 0) + 1;
            if (len / 2 < sum) return nums[i];
            count.put(nums[i], sum);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.majorityElement(new int[]{3, 2, 3}));
        // 2
        System.out.println(s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
