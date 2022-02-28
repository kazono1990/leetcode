package jp.co.kazono.leetcode.LC0228_Summary_Ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int length = nums.length;
        StringBuilder sb;
        for (int i = 0; i < length; i++) {
            sb = new StringBuilder();
            int num = nums[i];
            while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                sb.append(num).append("->").append(nums[i]);
                res.add(sb.toString());
            } else {
                sb.append(num);
                res.add(sb.toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).toArray()));
    }
}
