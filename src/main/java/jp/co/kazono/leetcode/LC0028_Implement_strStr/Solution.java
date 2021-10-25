package jp.co.kazono.leetcode.LC0028_Implement_strStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) break;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("aaaaa", "bba"));
        System.out.println(s.strStr("", ""));
        System.out.println(s.strStr("aaa", "aaaa"));
        System.out.println(s.strStr("mississippi", "mississippi"));
        System.out.println(s.strStr("mississippi", "issipi"));
    }
}
