package jp.co.kazono.leetcode.LC0165_Compare_Version_Numbers;

public class Solution {

    public int compareVersion(String version1, String version2) {
        // split each version by '.'
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        // check the max length
        int length = Math.max(ver1.length, ver2.length);
        for (int i = 0; i < length; i++) {
            // if ver1[i] = '001' then v1 = 1.
            Integer v1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
            Integer v2 = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) return compare;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.compareVersion("1.01", "1.001"));
        // 0
        System.out.println(s.compareVersion("1.0", "1.00"));
        // -1
        System.out.println(s.compareVersion("0.1", "1.1"));
    }
}
