package jp.co.kazono.leetcode.LC0997_Find_the_Town_Judge;

import java.util.Arrays;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] _trust = new int[n];
        int[] trusted = new int[n];

        for (int i = 0; i < trust.length; i++) {
            int person = trust[i][0];
            int t_person = trust[i][1];
            _trust[person - 1]++;
            trusted[t_person - 1]++;
        }
        // System.out.println(Arrays.toString(_trust));
        // System.out.println(Arrays.toString(trusted));
        for (int i = 0; i < n; i++) {
            if (_trust[i] == 0 && trusted[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findJudge(2, new int[][]{{1, 2}}));
        // 3
        System.out.println(s.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        // -1
        System.out.println(s.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }
}
