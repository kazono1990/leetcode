package jp.co.kazono.leetcode.LC0187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet();
        Set repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String dna = s.substring(i, i + 10);
            if (!seen.add(dna)) {
                repeated.add(dna);
            }
        }
        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> dnas = s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(Arrays.toString(dnas.toArray()));
    }
}
