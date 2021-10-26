package jp.co.kazono.leetcode.LC0029_Divide_Two_Integers;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;

        long x = Math.abs((long)dividend);
        long y = Math.abs((long)divisor);

        while (x >= y) {
            x -= y;
            result++;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10, 3));
        System.out.println(s.divide(-7, 3));
        System.out.println(s.divide(0, 1));
        System.out.println(s.divide(1, 1));
        System.out.println(s.divide(1, -1));
    }
}
