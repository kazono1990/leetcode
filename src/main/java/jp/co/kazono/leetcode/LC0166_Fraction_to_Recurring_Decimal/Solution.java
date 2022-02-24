package jp.co.kazono.leetcode.LC0166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part.
        res.append(num / den);
        num %= den;
        if (num == 0) return res.toString();

        // fractional part
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0.5
        System.out.println(s.fractionToDecimal(1, 2));
        // 1
        System.out.println(s.fractionToDecimal(2, 1));
        // 0.(012)
        System.out.println(s.fractionToDecimal(4, 333));
    }
}
