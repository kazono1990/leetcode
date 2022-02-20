package jp.co.kazono.leetcode.LC1288_Remove_Covered_Intervals;

import java.util.Arrays;

public class Solution {

    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0;
        int left = -1, right = -1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            if (interval[0] > left && interval[1] > right) {
                left = interval[0];
                res++;
            }
            right = Math.max(right, interval[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}}));
        // 1
        System.out.println(s.removeCoveredIntervals(new int[][]{{1, 4}, {2, 3}}));
    }
}
