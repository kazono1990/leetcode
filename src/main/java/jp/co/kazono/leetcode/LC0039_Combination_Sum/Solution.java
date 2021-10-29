package jp.co.kazono.leetcode.LC0039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), candidates, 0, target);
        return answer;
    }

    public void dfs(List<Integer> curr, int[] candidates, int idx, int target) {
        if (idx > candidates.length) {
            return;
        }
        if (idx == candidates.length || target <= 0 || candidates[idx] > target) {
            if (target == 0) answer.add(curr);
            return;
        }

        List<Integer> curr1 = new ArrayList<>();
        curr1.addAll(curr);
        for (int i = 0; i * candidates[idx] <= target; i++) {
            List<Integer> curr2 = new ArrayList<>();
            curr2.addAll(curr1);
            dfs(curr2, candidates, idx + 1, target - i * candidates[idx]);
            curr1.add(candidates[idx]);
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
        printList(s.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
