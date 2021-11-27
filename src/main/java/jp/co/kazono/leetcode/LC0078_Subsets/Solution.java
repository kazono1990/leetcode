package jp.co.kazono.leetcode.LC0078_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // add empty list.
        res.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : res) {
                newSubsets.add(new ArrayList<>(curr){{add(num);}});
                /*
                List<Integer> tmp = new ArrayList<>(curr);
                tmp.add(num);
                newSubsets.add(tmp);
                 */
            }
            res.addAll(newSubsets);
            /*
            for (List<Integer> curr : newSubsets) {
                res.add(curr);
            }
             */
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[]{1, 2, 3};
        List<List<Integer>> res = s.subsets(input);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
