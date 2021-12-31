package jp.co.kazono.leetcode.LC0118_Pascals_Triangle;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // add 1 to first and last position.
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int a = res.get(i - 1).get(j - 1);
                    int b = res.get(i - 1).get(j);
                    row.add(a + b);
                }
            }
            res.add(row);
        }
        return res;
    }

    private void printList(List<List<Integer>> lists) {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : lists) {
            sb.append(Arrays.toString(ArrayUtils.toPrimitive(list.toArray(new Integer[list.size()]))));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.generate(5));
    }
}
