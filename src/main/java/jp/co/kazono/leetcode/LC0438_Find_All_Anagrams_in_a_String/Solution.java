package jp.co.kazono.leetcode.LC0438_Find_All_Anagrams_in_a_String;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        // use sliding window to check anagrams.

        // check bad inputs.
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;

        // setup hashmap which track how many times each character appears.
        int[] chars = new int[26];
        for (Character c : p.toCharArray()) {
            chars[c - 'a']++;
        }

        // start = start poniter
        // end = end pointer
        // len = length of anagram to find
        // diff = length of currently found anagram. If it equals 0 it must have been found
        int start = 0, end = 0, len = p.length(), diff = len;
        for (end = 0; end < len; end++) {
            char tmp = s.charAt(end);
            chars[tmp - 'a']--;
            if (chars[tmp - 'a'] >= 0) diff--;
        }

        //This would mean that s began with an anagram of p
        if (diff == 0) res.add(0);
        System.out.println(diff);

        //At this point, start remains at 0, end has moved so that the window is the length of the anagram
        while (end < s.length()) {
            char tmp = s.charAt(start);
            if (chars[tmp - 'a'] >= 0) {
                diff++;
            }

            //Increment the hash value for this character, because it is no longer contained in the window
            chars[tmp - 'a']++;
            start++;

            tmp = s.charAt(end);
            chars[tmp - 'a']--;
            if (chars[tmp - 'a'] >= 0){
                diff--;
            }

            if (diff == 0){
                res.add(start);
            }

            end++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> anagrams = s.findAnagrams("cbaebabacd", "abc");
        System.out.println(Arrays.toString(ArrayUtils.toPrimitive(anagrams.toArray(new Integer[anagrams.size()]))));
    }
}
