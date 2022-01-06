package jp.co.kazono.leetcode.LC0131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Backtracking
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, res, new ArrayList<String>(), s);
        return res;
    }

    private void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    private void printList(List<List<String>> lists) {
        StringBuilder sb = new StringBuilder();
        for (List<String> partition : lists) {
            sb.append(Arrays.toString(partition.toArray()));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input_1 = "aab";
        List<List<String>> partition_1 = s.partition(input_1);
        s.printList(partition_1);
        String input_2 = "a";
        List<List<String>> partition_2 = s.partition(input_2);
        s.printList(partition_2);
    }
}
