package jp.co.kazono.leetcode.LC0058_Length_of_Last_Word;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        String lastWord = s.substring(s.lastIndexOf(" ") + 1);
        return lastWord.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("Hello World"));
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
    }
}
