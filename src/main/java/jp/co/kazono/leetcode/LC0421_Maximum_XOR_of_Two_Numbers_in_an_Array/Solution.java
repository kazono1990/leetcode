package jp.co.kazono.leetcode.LC0421_Maximum_XOR_of_Two_Numbers_in_an_Array;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;

        // greedy part.
        for (int i = 31; i >= 0; i--) {
            // create all mask (e.g. 100...000, 110...000, 111...000, ... 111...111 )
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // reserve Left bits and ignore Right bits
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 28
        System.out.println(s.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        // 127
        System.out.println(s.findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }
}
