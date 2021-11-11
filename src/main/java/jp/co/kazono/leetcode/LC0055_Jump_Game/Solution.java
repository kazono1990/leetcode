package jp.co.kazono.leetcode.LC0055_Jump_Game;

public class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(s.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
