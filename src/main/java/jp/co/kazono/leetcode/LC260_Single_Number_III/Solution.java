package jp.co.kazono.leetcode.LC260_Single_Number_III;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i : nums) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.singleNumber(new int[]{1,2,1,3,2,5});
        s.singleNumber(new int[]{-1, 0});
        s.singleNumber(new int[]{0, 1});
    }

}
