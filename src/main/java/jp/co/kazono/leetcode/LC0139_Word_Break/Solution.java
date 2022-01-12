package jp.co.kazono.leetcode.LC0139_Word_Break;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
