package jp.co.kazono.leetcode.LC0090_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) return res;

        // Initialize the list.
        res.add(new ArrayList<>());
        res.add(new ArrayList<>(){{add(nums[0]);}});
        int prev = 1;


        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            if (nums[i] != nums[i - 1]) {
                prev = size;
            }
            for (int j = size - prev; j < size; j++) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> subsets = s.subsetsWithDup(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(Arrays.toString(subset.toArray()));
        }
    }
}
