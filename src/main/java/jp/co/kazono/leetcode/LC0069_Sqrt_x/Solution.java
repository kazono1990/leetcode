package jp.co.kazono.leetcode.LC0069_Sqrt_x;

public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int left = 1;
        int right = x;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (middle > x / middle) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(4));
        System.out.println(s.mySqrt(8));
        System.out.println(s.mySqrt(9));
    }
}
