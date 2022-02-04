package jp.co.kazono.leetcode.LC0454_4Sum_II;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        int res = 0;


        // get all possible two-sums between nums3 and nums4.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // count the number of two-sums between nums1 and nums2
        // which equals to opposite of any two-sum between nums3 and nums4.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                if (map.containsKey(-sum)) {
                    res += map.get(-sum);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};
        // 2
        System.out.println(s.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
