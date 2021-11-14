package jp.co.kazono.leetcode.LC0062_Unique_Paths;

public class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2; // how much steps we need to do.
        int k =  m - 1; // number of steps that need to go down.
        double res = 1;

        // Combination(N, k) = N! / (k!(N - k)!)
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7));
    }
}
