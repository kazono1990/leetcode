package jp.co.kazono.leetcode.LC1675_Minimize_Deviation_in_Array;

import java.util.PriorityQueue;

public class Solution {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = nums.length, mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1) num *= 2;
            pq.add(-num);
            mi = Math.min(mi, num);
        }

        while (true) {
            int a = -pq.poll();
            res = Math.min(res, a - mi);
            if (a % 2 == 1) break;
            mi = Math.min(mi, a / 2);
            pq.add(-a / 2);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minimumDeviation(new int[]{1, 2, 3, 4}));
        // 3
        System.out.println(s.minimumDeviation(new int[]{4, 1, 5, 20, 3}));
    }
}
