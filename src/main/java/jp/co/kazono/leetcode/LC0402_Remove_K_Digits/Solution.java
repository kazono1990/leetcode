package jp.co.kazono.leetcode.LC0402_Remove_K_Digits;

import java.util.Stack;

public class Solution {

    public String removeKdigits(String num, int k) {
        int len = num.length();

        // corner case
        if (len == k) return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < len) {
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        // construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());

        // remove all 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1219
        System.out.println(s.removeKdigits("1432219", 3));
        // 200
        System.out.println(s.removeKdigits("10200", 1));
        // 0
        System.out.println(s.removeKdigits("10", 2));
    }
}
