package jp.co.kazono.leetcode.LC1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60;

public class Solution {

    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) return 0;
        int len = time.length;
        int[] mod = new int[60];
        for (int i = 0; i < len; i++) {
            int remainder = time[i] % 60;
            mod[remainder]++;
        }

        int res = 0;
        res += mod[0] * (mod[0] - 1) / 2;
        res += mod[30] * (mod[30] - 1) / 2;
        for(int i = 1; i < 30; i++) {
            res += mod[i] * mod[60 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(s.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
