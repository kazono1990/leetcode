package jp.co.kazono.leetcode.LC0172_Factorial_Trailing_Zeroes;

public class Solution {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.trailingZeroes(3));
        // 1
        System.out.println(s.trailingZeroes(5));
        // 0
        System.out.println(s.trailingZeroes(0));
    }
}
