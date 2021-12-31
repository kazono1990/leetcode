package jp.co.kazono.leetcode.LC0119_Pascals_Triangle_II;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        res[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            // formula
            // [C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]
            // C(k,i) = C(k,i-1) * (k-i+1)/i
            res[i] = (int)(((long)res[i - 1] * (rowIndex - i + 1)) / i);
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> answer = s.getRow(7);
        System.out.println(Arrays.toString(ArrayUtils.toPrimitive(answer.toArray(new Integer[answer.size()]))));
    }
}
