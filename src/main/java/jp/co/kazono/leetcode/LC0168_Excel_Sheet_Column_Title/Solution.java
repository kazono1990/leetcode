package jp.co.kazono.leetcode.LC0168_Excel_Sheet_Column_Title;

public class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.insert(0, (char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // A
        System.out.println(s.convertToTitle(1));
        // AB
        System.out.println(s.convertToTitle(28));
    }
}
