package jp.co.kazono.leetcode.LC0093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();

        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    int d = len - a - b - c;
                    if (0 < d && d <= 3) {
                        int A = Integer.parseInt(s.substring(0, a));
                        int B = Integer.parseInt(s.substring(a, a + b));
                        int C = Integer.parseInt(s.substring(a + b, a + b + c));
                        int D = Integer.parseInt(s.substring(a + b + c));
                        System.out.println(A + ", " + B + ", " + C + ", " + D);
                        if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                            if (sb.length() == len + 3) {
                                ans.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.restoreIpAddresses("25525511135").toArray()));
        System.out.println(Arrays.toString(s.restoreIpAddresses("0000").toArray()));
        System.out.println(Arrays.toString(s.restoreIpAddresses("1111").toArray()));
        System.out.println(Arrays.toString(s.restoreIpAddresses("010010").toArray()));
        System.out.println(Arrays.toString(s.restoreIpAddresses("101023").toArray()));
    }
}
