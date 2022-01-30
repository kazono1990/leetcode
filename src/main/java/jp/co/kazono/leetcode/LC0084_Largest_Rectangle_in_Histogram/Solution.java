package jp.co.kazono.leetcode.LC0084_Largest_Rectangle_in_Histogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i <= len) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 10
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        // 4
        System.out.println(s.largestRectangleArea(new int[]{2, 4}));
    }
}
