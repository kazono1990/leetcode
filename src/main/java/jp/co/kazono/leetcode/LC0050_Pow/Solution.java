package jp.co.kazono.leetcode.LC0050_Pow;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            return 1/x * myPow(1/x, -(n + 1));
        }
        return (n % 2 == 0) ? myPow(x * x, n/2) : x * myPow(x * x, n/2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2.00000, 10));
        System.out.println(s.myPow(2.10000, 3));
        System.out.println(s.myPow(2.00000, -2));
    }
}
