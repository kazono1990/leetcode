package jp.co.kazono.leetcode.LC0740_Delete_and_Earn;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        Map<Integer, Integer> points = new HashMap<>();

        // precompute how many pointswe gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        // base case
        int twoBack = 0;
        int oneBack = points.getOrDefault(1, 0);

        for (int num = 2; num <= maxNumber; num++) {
            int tmp = oneBack;
            oneBack = Math.max(oneBack, twoBack + points.getOrDefault(num, 0));
            twoBack = tmp;
        }

        return oneBack;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.deleteAndEarn(new int[]{3, 4, 2}));
        // 9
        System.out.println(s.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));

    }
}
