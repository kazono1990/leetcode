package jp.co.kazono.leetcode.LC0040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, answer);
        return answer;
    }

    public void dfs(int[] candidate, int curr, int target, List<Integer> path, List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList(path));
            return;
        }

        if (target < 0) return;
        System.out.println(curr);
        for (int i = curr; i < candidate.length; i++) {
            if (i > curr && candidate[i] == candidate[i - 1]) continue;
            path.add(path.size(), candidate[i]);
            dfs(candidate, i + 1, target - candidate[i], path, answer);
            path.remove(path.size() - 1);
        }
    }

    public static void printList(List<List<Integer>> lists) {
        for (List list : lists) {
            System.out.print("[");
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() -1) {
                    System.out.print(list.get(i) + ", ");
                }
                else {
                    System.out.print(list.get(i));
                }
            }
            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        printList(s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
