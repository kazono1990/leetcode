package jp.co.kazono.leetcode.LC0290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Object, Object> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
        // false
        System.out.println(s.wordPattern("abba", "dog cat cat fish"));
        // false
        System.out.println(s.wordPattern("aaaa", "dog cat cat dog"));
    }
}
