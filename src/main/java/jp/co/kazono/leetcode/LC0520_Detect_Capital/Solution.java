package jp.co.kazono.leetcode.LC0520_Detect_Capital;

public class Solution {

    public boolean detectCapitalUse(String word) {
        int n = word.length();

        if (n == 1) {
            return true;
        }

        // Case 1: All capital
        // e.g. USA
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < n; i++) {
                if (Character.isLowerCase(word.charAt(i))) return false;
            }
        }
        // Case 2 and Case 3:
        // e.g. leetcode (Case 2) / Google (Case 3)
        else {
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.detectCapitalUse("USA"));
        // true
        System.out.println(s.detectCapitalUse("leetcode"));
        // true
        System.out.println(s.detectCapitalUse("Google"));
        // false
        System.out.println(s.detectCapitalUse("FlaG"));
    }
}
