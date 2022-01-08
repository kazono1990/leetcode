package jp.co.kazono.leetcode.LC0137_Single_Number_II;

public class Solution {

    public int singleNumber(int[] nums) {
        int ans = 0;
        // we have 32 bits integers as input
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                // check each bit and if bit == 0 then sum++
                if ((num >> i & 1) == 1) sum++;
            }
            // divided by 3
            sum %= 3;
            // OR calc
            ans |= sum << i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.singleNumber(new int[]{2, 2, 3, 2}));
        // 99
        System.out.println(s.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
