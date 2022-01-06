package jp.co.kazono.leetcode.LC0131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2 {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        // if s.substring(start, end + 1) is palindrome, dp[start][end] = true, else dp[start][end] = false.
        boolean[][] dp = new boolean[len][len];
        dfs(res, s, 0, new ArrayList<>(), dp);
        return res;
    }

    private void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private void printList(List<List<String>> lists) {
        StringBuilder sb = new StringBuilder();
        for (List<String> partition : lists) {
            sb.append(Arrays.toString(partition.toArray()));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution_2 s = new Solution_2();
        String input_1 = "aab";
        List<List<String>> partition_1 = s.partition(input_1);
        s.printList(partition_1);
        String input_2 = "a";
        List<List<String>> partition_2 = s.partition(input_2);
        s.printList(partition_2);

    }
}
