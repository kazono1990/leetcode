package jp.co.kazono.leetcode.LC0567_Permutation_in_String;

import java.util.Arrays;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i)-'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2Map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2Map[s2.charAt(i + j) - 'a']++;
            }
            if (Arrays.equals(s1Map, s2Map)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkInclusion("ab", "eidbaooo"));
    }
}
