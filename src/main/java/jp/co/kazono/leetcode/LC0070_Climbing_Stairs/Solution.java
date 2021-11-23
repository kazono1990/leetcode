package jp.co.kazono.leetcode.LC0070_Climbing_Stairs;

public class Solution {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1;
        int b = 2;
        for (int i = 3; i <=n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(2));
        System.out.println(s.climbStairs(3));
    }
}
