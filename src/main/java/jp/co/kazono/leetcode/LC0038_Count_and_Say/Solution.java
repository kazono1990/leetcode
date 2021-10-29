package jp.co.kazono.leetcode.LC0038_Count_and_Say;

public class Solution {
    public String countAndSay(int n) {
        StringBuilder current = new StringBuilder("1");
        StringBuilder previous;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            previous = current;
            current = new StringBuilder();
            count = 1;
            say = previous.charAt(0);

            for (int j = 1; j < previous.length(); j++) {
                if (previous.charAt(j) != say) {
                    current.append(count).append(say);
                    count = 1;
                    say = previous.charAt(j);
                } else {
                    count++;
                }
            }
            current.append(count).append(say);
        }
        return current.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(1));
        System.out.println(s.countAndSay(4));
        System.out.println(s.countAndSay(5));
    }
}
