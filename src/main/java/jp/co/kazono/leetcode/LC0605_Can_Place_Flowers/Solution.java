package jp.co.kazono.leetcode.LC0605_Can_Place_Flowers;

public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;

        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }

        return n <= count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        // false
        System.out.println(s.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        // false
        System.out.println(s.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
    }
}
