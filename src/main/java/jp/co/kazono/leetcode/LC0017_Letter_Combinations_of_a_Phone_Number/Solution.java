package jp.co.kazono.leetcode.LC0017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        List<String> result = new LinkedList<>();
        process(0, new StringBuilder(), map, digits, result);
        return result;
    }

    public void process(int i, StringBuilder sb, HashMap<Character, String> map, String digits, List<String> result) {
        if (i == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(i));
        for (int _i = 0; _i < str.length(); _i++) {
            sb.append(str.charAt(_i));
            process(i + 1, sb, map, digits, result);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations("234"));
    }
}
