package jp.co.kazono.leetcode.LC0392_Is_Subsequence;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int idx_s = 0, idx_t = 0;
        while (idx_t < t.length()) {
            if (s.charAt(idx_s) == t.charAt(idx_t)) {
                idx_s++;
                if (idx_s == s.length()) return true;
            }
            idx_t++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        // false
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
    }
}
