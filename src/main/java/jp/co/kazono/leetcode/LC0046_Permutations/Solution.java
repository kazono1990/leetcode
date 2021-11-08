package jp.co.kazono.leetcode.LC0046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums.length == 0) return answer;

        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(nums[0]);
        answer.add(tmpList);
        for (int i = 1; i < nums.length; ++i) {
            List<List<Integer>> newAnswer = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                for (List<Integer> list : answer) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(j, nums[i]);
                    newAnswer.add(tmp);
                }
            }
            answer = newAnswer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.permute(new int[]{1, 2, 3});
        s.permute(new int[]{0, 1});
    }
}
