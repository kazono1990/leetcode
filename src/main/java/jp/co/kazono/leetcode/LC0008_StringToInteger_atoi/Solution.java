package jp.co.kazono.leetcode.LC0008_StringToInteger_atoi;

public class Solution {

    public int myAtoi(String str) {
        // 空白削除
        str = str.trim();

        if (str == null || str.length() == 0) {
            return 0;
        }

        // 負数か正数かを判断するためのフラグ
        boolean isNegative = false;
        int startIndex = 0;

        // 先頭文字が記号である場合、開始位置を一つ後ろにずらす
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            startIndex++;
        }

        // もし'-'だった場合、isNegativeをtrueへ
        if (str.charAt(0) == '-') {
            isNegative = true;
        }

        double result = 0;
        for (int i = startIndex; i < str.length(); i++) {
            // 0 ~ 9の範囲に治らない場合は終了
            if (str.charAt(i) < '0' || '9' < str.charAt(i)) {
                break;
            }

            // charAt(i) の文字を数値に変換
            int digit = (int)(str.charAt(i) - '0');
            result = result * 10 + digit;
        }

        // isNegativeの値に応じて正負を変換
        if (isNegative) {
            result = -result;
        }

        // Integer.MAX_VALUEを以上の場合は、Integer.MAX_VALUEを返却
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        // Integer.MIN_VALUEを以下の場合は、Integer.MIN_VALUEを返却
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 42
        System.out.println(s.myAtoi("42"));
        // -42
        System.out.println(s.myAtoi("   -42"));
        // 4193
        System.out.println(s.myAtoi("4193 with words"));
        // 0
        System.out.println(s.myAtoi("words and 987"));
        // -2147483648
        System.out.println(s.myAtoi("-91283472332"));
        // 0
        System.out.println(s.myAtoi(" "));
        // -12
        System.out.println(s.myAtoi("  -0012a42"));

    }
}
