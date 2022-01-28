package jp.co.kazono.leetcode.LC0412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");
            if (i % 3 != 0 && i % 5 != 0) sb.append(i);
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1, 2, Fizz]
        System.out.println(Arrays.toString(s.fizzBuzz(3).toArray()));
        // [1, 2, Fizz, 4, Buzz]
        System.out.println(Arrays.toString(s.fizzBuzz(5).toArray()));
        // [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
        System.out.println(Arrays.toString(s.fizzBuzz(15).toArray()));
    }
}
