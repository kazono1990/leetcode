package jp.co.kazono.leetcode.LC0003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // {文字, 出現順番}を格納するMapを作成
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length(), answer = 0;
        for (int j = 0, i = 0; j < n; j++) {
            // map内に現在参照している文字が存在する場合
            if (map.containsKey(s.charAt(j))) {
                // 前回出現した同じ文字のindexをiに格納
                i = Math.max(map.get(s.charAt(j)), i);
            }
            // 現在の最大文字列長と、現在の文字列長を比較し、長い方をanswerに格納
            answer = Math.max(answer, j - i + 1);
            // 現在の文字の出現位置をmapに格納
            map.put(s.charAt(j), j + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        // 1
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        // 3
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        // 1
        System.out.println(s.lengthOfLongestSubstring(" "));
        // 3
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
        // 5
        System.out.println(s.lengthOfLongestSubstring("tmmzuxt"));
    }
}
