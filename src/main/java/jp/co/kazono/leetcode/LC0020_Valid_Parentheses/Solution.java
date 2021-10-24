package jp.co.kazono.leetcode.LC0020_Valid_Parentheses;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> letters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(map.containsKey(tmp)) {
                if (letters.isEmpty() || letters.pop() != map.get(tmp)) {
                    return false;
                }
            }
            else {
                letters.push(tmp);
            }
        }
        return letters.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("{[]}"));
    }
}
