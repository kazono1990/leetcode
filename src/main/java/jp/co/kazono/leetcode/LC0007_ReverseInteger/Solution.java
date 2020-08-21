package jp.co.kazono.leetcode.LC0007_ReverseInteger;

public class Solution {

    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            reverse = 10 * reverse + pop;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 321
        System.out.println(s.reverse(123));
        // -321
        System.out.println(s.reverse(-123));
        // 21
        System.out.println(s.reverse(120));
        // 0
        System.out.println(s.reverse(1534236469));
        // 0 (Integer.MAX_VALUE)
        System.out.println(s.reverse(2147483647));
        // 0 (Integer.MIN_VALUE)
        System.out.println(s.reverse(-2147483648));
    }
}
