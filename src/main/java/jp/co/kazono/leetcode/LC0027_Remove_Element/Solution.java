package jp.co.kazono.leetcode.LC0027_Remove_Element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i++] =num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(s.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
