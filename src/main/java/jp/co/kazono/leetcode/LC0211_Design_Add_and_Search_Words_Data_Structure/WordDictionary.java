package jp.co.kazono.leetcode.LC0211_Design_Add_and_Search_Words_Data_Structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary {

    private Map<Integer, List<String>> map;

    public WordDictionary() {
        this.map = new HashMap<>();
    }

    public void addWord(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(index, list);
        } else {
            map.get(index).add(word);
        }
    }

    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)) return false;
        List<String> list = map.get(index);

        for (String s : list) {
            if (isSame(s, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(String s, String word) {
        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
