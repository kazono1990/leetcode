package jp.co.kazono.leetcode.LC0096_Unique_Binary_Search_Trees;

public class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(3));
    }
}
