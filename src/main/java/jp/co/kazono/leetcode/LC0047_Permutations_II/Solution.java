package jp.co.kazono.leetcode.LC0047_Permutations_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        permute(nums, 0, answer);
        return answer;
    }

    public void permute(int[] nums, int start, List<List<Integer>> answer) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            answer.add(list);
            return;
        }

        Set<Integer> set = new HashSet();
        for (int i = start; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, start, i);
                permute(nums, start+1, answer);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void printList(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            for (int i : list) {
                sb.append(i + " ");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.permuteUnique(new int[]{1, 1, 2}));
    }
}
