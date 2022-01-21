package jp.co.kazono.leetcode.LC0875_Koko_Eating_Bananas;

public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = (left+ right) / 2;
            int hourSpent = 0;

            for (int pile : piles) {
                hourSpent += Math.ceil((double)pile / middle);
            }

            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
