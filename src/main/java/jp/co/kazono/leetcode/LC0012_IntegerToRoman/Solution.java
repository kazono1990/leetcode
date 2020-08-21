package jp.co.kazono.leetcode.LC0012_IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String intToRoman(int num) {
        int[] sizes = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder answer = new StringBuilder();

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        for (Integer size : sizes) {
            int count = num / size;
            for (int i = 0; i < count; i++) {
                answer.append(map.get(size));
            }
            num = num - count * size;
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // III
        System.out.println(s.intToRoman(3));
        // IV
        System.out.println(s.intToRoman(4));
        // IX
        System.out.println(s.intToRoman(9));
        // LVIII
        System.out.println(s.intToRoman(58));
        // MCMXCIV
        System.out.println(s.intToRoman(1994));
    }
}
