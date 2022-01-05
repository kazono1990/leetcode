package jp.co.kazono.leetcode.LC1009_Complement_of_Base_10_Integer;

public class Solution {

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;

        // get mask
        // if you can use Integer.highestOneBit(), you can get same value by following line
        // int mask = (Integer.highestOneBit(n) << 1) - 1;
        int mask = 1;
        while (mask <= n) {
            mask = mask << 1;
        }
        return n ^ (mask - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.bitwiseComplement(5));
        System.out.println(s.bitwiseComplement(7));
        System.out.println(s.bitwiseComplement(10));
    }
}
