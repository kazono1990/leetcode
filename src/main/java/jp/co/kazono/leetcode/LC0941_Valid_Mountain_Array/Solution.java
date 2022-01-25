package jp.co.kazono.leetcode.LC0941_Valid_Mountain_Array;

public class Solution {

    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        int i = 0;

        // walk up.
        while (i + 1 < len && arr[i] < arr[i + 1]) i++;

        // if peak is left or right side, then return false.
        if (i == 0 || i == len - 1) {
            return false;
        }

        // walk down.
        while (i + 1 < len && arr[i] > arr[i + 1]) i++;

        return len - 1 == i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.validMountainArray(new int[]{2, 1}));
        // false
        System.out.println(s.validMountainArray(new int[]{3, 5, 5}));
        // true
        System.out.println(s.validMountainArray(new int[]{0, 3, 2, 1}));
    }
}
