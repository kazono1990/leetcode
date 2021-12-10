package jp.co.kazono.leetcode.LC0299_Bulls_and_Cows;

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
                if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return String.format("%dA%dB", bulls, cows);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1A3B
        System.out.println(s.getHint("1807", "7810"));
        // 1A1B
        System.out.println(s.getHint("1123", "0111"));
        // 0A0B
        System.out.println(s.getHint("1", "0"));
        // 1A0B
        System.out.println(s.getHint("1", "1"));
        // 1A0B
        System.out.println(s.getHint("11", "10"));
    }
}
