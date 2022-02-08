package jp.co.kazono.leetcode.LC0389_Find_the_Difference;

public class Solution {

    public char findTheDifference(String s, String t) {
        int charCode = t.charAt(s.length());
        for (int i = 0; i < s.length(); i++) {
            charCode -= (int)s.charAt(i);
            charCode += (int)t.charAt(i);
        }
        return (char)charCode;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // e
        System.out.println(s.findTheDifference("abcd", "abcde"));
        // y
        System.out.println(s.findTheDifference("", "y"));
    }
}
