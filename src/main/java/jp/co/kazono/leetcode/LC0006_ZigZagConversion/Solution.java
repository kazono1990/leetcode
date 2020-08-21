package jp.co.kazono.leetcode.LC0006_ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int curr = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curr).append(c);
            if (curr == 0 || curr == numRows - 1) goingDown = !goingDown;
            curr += goingDown ? 1: -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // PAHNAPLSIIGYIR
        System.out.println(s.convert("PAYPALISHIRING", 3));
        // PINALSIGYAHRPI
        System.out.println(s.convert("PAYPALISHIRING", 4));
    }
}
