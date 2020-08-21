package jp.co.kazono.leetcode.LC0009_PalindromeNumber;

public class Solution {

    public boolean isPalindrome(int x) {
        // 負の数や10で割り切れてしまう場合はそもそもPalindromeにならない
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        while (x > reversedNumber) {
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }

        // 12321のように奇数の入力が与えられた場合、x = 12、 reversedNumber = 123となる
        // この場合を対処できるように、「reversedNumber / 10」を実施し、上二桁で比較を行うようにする
        return x == reversedNumber || x == reversedNumber/10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isPalindrome(121));
        // true
        System.out.println(s.isPalindrome(1221));
        // false
        System.out.println(s.isPalindrome(-121));
        // false
        System.out.println(s.isPalindrome(10));
        // true
        System.out.println(s.isPalindrome(12321));
    }
}
