package jp.co.kazono.leetcode.LC0258_Add_Digits;

public class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.addDigits(38));
    }
}
