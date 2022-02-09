package jp.co.kazono.leetcode.LC0532_K_diff_Pairs_in_an_Array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findPairs(int[] nums, int k) {
        if (nums == null | nums.length == 0 || k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) count++;
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }
}
