package jp.co.kazono.leetcode.LC0167_Two_Sum_II_Input_Array_Is_Sorted;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1, 2]
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
        // [1, 3]
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 3, 4}, 6)));
        // [1, 2]
        System.out.println(Arrays.toString(s.twoSum(new int[]{-1, 0}, -1)));
    }
}
