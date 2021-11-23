package jp.co.kazono.leetcode.LC0066_Plus_One;

public class Solution {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.plusOne(new int[]{1, 2, 4});
    }
}
