package jp.co.kazono.leetcode.LC0005_LongestPalindromicSubstring;

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 怪文の中心が1文字の場合
            int len1 = expand(s, i, i);

            // 怪文の中心が２文字の場合
            int len2 = expand(s, i, i + 1);

            // 文字列長が長い方を選択
            int len = Math.max(len1, len2);

            if (len > (right - left)) {
                // 開始位置と終端位置を計算
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }

        }
        return s.substring(left, right + 1);
    }

    private int expand(String str, int left, int right) {
        int L = left, R = right;
        while(0 <= L && R < str.length() && str.charAt(L) == str.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // bab
        System.out.println(s.longestPalindrome("babad"));
    }
}
