package jp.co.kazono.leetcode.LC0049_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] char_array = str.toCharArray();
            Arrays.sort(char_array);
            String key = String.valueOf(char_array);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public void printList(List<List<String>> lists) {
        for (List<String> list : lists) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            for (String str : list) {
                sb.append(str + " ");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
