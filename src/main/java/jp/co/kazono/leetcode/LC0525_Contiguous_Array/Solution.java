package jp.co.kazono.leetcode.LC0525_Contiguous_Array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + ((nums[i] == 1) ? 1 : -1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMaxLength(new int[]{0, 1}));
        System.out.println(s.findMaxLength(new int[]{0, 1, 0}));
    }
}
