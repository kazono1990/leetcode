package jp.co.kazono.leetcode.LC0973_K_Closest_Points_to_Origin;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        // Sort the array with a custom lambda comparator function
        Arrays.sort(points, (a, b) -> squaredDistance(a) - squaredDistance(b));

        // Return the first k elements of the sorted array
        return Arrays.copyOf(points, k);
    }

    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void printPoint(int[][] points) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < points.length; i++) {
            sb.append(Arrays.toString(points[i]));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points_1 = new int[][]{{1, 3}, {-2, 2}};
        s.printPoint(points_1);
        s.printPoint(s.kClosest(points_1, 1));

        int[][] points_2 = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        s.printPoint(points_2);
        s.printPoint(s.kClosest(points_2, 2));
    }
}
