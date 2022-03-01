package jp.co.kazono.leetcode.LC0338_Counting_Bits;

import java.util.Arrays;

public class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset *= 2;
            }
            res[i] = 1 + res[i - offset];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.countBits(2)));
    }
}
