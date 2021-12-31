package jp.co.kazono.leetcode.LC0120_Triangle;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> tmp = triangle.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                res[j] = Math.min(res[j], res[j + 1]) + tmp.get(j);
            }
        }
        return res[0];
    }

    private List<List<Integer>> generateTriangle(int[][] nums) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] num : nums) {
            List<Integer> layer = new ArrayList<>();
            for (int element : num) {
                layer.add(element);
            }
            triangle.add(layer);
        }
        return triangle;
    }

    private void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> layer : triangle) {
            System.out.println(ArrayUtils.toPrimitive(layer));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangle = s.generateTriangle(nums);
        s.printTriangle(triangle);
        System.out.println(s.minimumTotal(triangle));

    }
}
