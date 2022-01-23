package jp.co.kazono.leetcode.LC1291_Sequential_Digits;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int digit = 1; digit < 9; digit++) {
            int next = digit;
            int n = next;
            while (n <= high && next < 10) {
                if (n >= low) {
                    res.add(n);
                }
                n = n * 10 + ++next;
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 123, 234
        List<Integer> sequential = s.sequentialDigits(100, 300);
        System.out.println(Arrays.toString(ArrayUtils.toPrimitive(sequential.toArray(new Integer[sequential.size()]))));
    }
}
