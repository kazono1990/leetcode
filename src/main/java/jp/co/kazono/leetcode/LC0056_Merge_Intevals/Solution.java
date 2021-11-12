package jp.co.kazono.leetcode.LC0056_Merge_Intevals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            }
            else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }

    public void printList(int[][] intervals) {
        for (int[] interval : intervals) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            for (int num : interval) {
                sb.append(num + " ");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.merge(new int[][]{
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}}));
        s.printList(s.merge(new int[][]{
            {1, 4},
            {4, 5}}));
        s.printList(s.merge(new int[][]{
            {1, 4},
            {0, 4}}));
    }
}
