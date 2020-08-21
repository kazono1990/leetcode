package jp.co.kazono.leetcode.LC0013_RomanToInteger;

public class Solution {

    public int romanToInt(String s) {
        int answer = 0;

        if (s.contains("IV")) {
            answer += 4;
            s = s.replaceAll("IV", "");
        }
        if (s.contains("IX")) {
            answer += 9;
            s = s.replaceAll("IX", "");
        }
        if (s.contains("XL")) {
            answer += 40;
            s = s.replaceAll("XL", "");
        }
        if (s.contains("XC")) {
            answer += 90;
            s = s.replaceAll("XC", "");
        }
        if (s.contains("CD")) {
            answer += 400;
            s = s.replaceAll("CD", "");
        }
        if (s.contains("CM")) {
            answer += 900;
            s = s.replaceAll("CM", "");
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    answer += 1;
                    break;
                case 'V':
                    answer += 5;
                    break;
                case 'X':
                    answer += 10;
                    break;
                case 'L':
                    answer += 50;
                    break;
                case 'C':
                    answer += 100;
                    break;
                case 'D':
                    answer += 500;
                    break;
                case 'M':
                    answer += 1000;
                    break;
                default:
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.romanToInt("III"));
        // 4
        System.out.println(s.romanToInt("IV"));
        // 9
        System.out.println(s.romanToInt("IX"));
        // 58
        System.out.println(s.romanToInt("LVIII"));
        // 1994
        System.out.println(s.romanToInt("MCMXCIV"));
    }
}
