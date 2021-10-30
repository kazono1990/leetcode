package jp.co.kazono.leetcode.LC0043_Multiply_Strings;

public class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        int [] answer = new int[num1.length() + num2.length() - 1];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                answer[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = answer.length - 1; i > 0; i--) {
            answer[i - 1] += answer[i] / 10;
            answer[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("2", "3"));
        System.out.println(s.multiply("123", "456"));
        System.out.println(s.multiply("123456789", "987654321"));
    }
}
