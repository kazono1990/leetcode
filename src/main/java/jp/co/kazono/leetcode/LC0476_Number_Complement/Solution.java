package jp.co.kazono.leetcode.LC0476_Number_Complement;

public class Solution {
    public int findComplement(int num) {
        // create mask
        // e.g. num = 5 → mask = 7 (111)
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        // get XOR
        return num ^ mask;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findComplement(5));
    }
}
