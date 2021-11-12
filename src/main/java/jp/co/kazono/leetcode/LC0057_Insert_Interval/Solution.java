package jp.co.kazono.leetcode.LC0057_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                res.add(interval);
            }
            else if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (newInterval != null) {
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][]);
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
        s.printList(s.insert(new int[][]{
            {1, 3},
            {6, 9}},
            new int[]{2, 5}));

        s.printList(s.insert(new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}},
            new int[]{4, 8}));
    }
}
