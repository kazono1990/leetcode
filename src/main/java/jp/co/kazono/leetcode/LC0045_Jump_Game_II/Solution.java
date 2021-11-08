package jp.co.kazono.leetcode.LC0045_Jump_Game_II;

public class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
                if (curEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
