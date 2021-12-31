package jp.co.kazono.leetcode.LC0125_Valid_Palindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int left = 0;
        int right = s.length() - 1;
        char cHead;
        char cTail;
        while(left <= right) {
            cHead = s.charAt(left);
            cTail = s.charAt(right);
            if (!Character.isLetterOrDigit(cHead)) {
                left++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                right--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) return false;
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(s.isPalindrome("race a car"));
        System.out.println(s.isPalindrome(" "));
    }
}
