package jp.co.kazono.leetcode.LC0171_Excel_Sheet_Column_Number;

public class Solution {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null) return -1;
        int res = 0;
        for (char c : columnTitle.toUpperCase().toCharArray()) {
            res *= 26;
            res += c - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.titleToNumber("A"));
        // 28
        System.out.println(s.titleToNumber("AB"));
    }
}
