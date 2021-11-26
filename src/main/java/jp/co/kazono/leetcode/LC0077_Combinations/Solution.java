package jp.co.kazono.leetcode.LC0077_Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k == 0) return res;

        res = combine(n - 1, k - 1);
        // if res is empty, initialize list using empty list.
        if (res.isEmpty()) res.add(new ArrayList<>());
        // add n to res.
        for (List<Integer> list : res) list.add(n);

        // Do not add n to res.
        res.addAll(combine(n - 1, k));
        return res;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> combinations = s.combine(4, 2);
        for (List<Integer> combination : combinations) {
            System.out.println(Arrays.toString(combination.toArray()));
        }
    }
}
