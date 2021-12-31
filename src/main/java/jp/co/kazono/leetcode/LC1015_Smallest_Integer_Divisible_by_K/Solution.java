package jp.co.kazono.leetcode.LC1015_Smallest_Integer_Divisible_by_K;

public class Solution {
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;
        for (int len = 1; len <= k; len++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return len;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.smallestRepunitDivByK(1));
        System.out.println(s.smallestRepunitDivByK(2));
        System.out.println(s.smallestRepunitDivByK(3));
    }
}
