package jp.co.kazono.leetcode.LC0127_Word_Ladder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            if (queue.contains(endWord)) return level;

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                StringBuilder sb = new StringBuilder(cur);
                for (int j = 0; j < cur.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        // 1文字ずつ文字をa~zに置換していく
                        sb.setCharAt(j, k);
                        // 置換結果がdicに含まれている場合queueに追加
                        if (dic.contains(sb.toString())) {
                            queue.offer(sb.toString());
                            // 重複して同じ単語を登録しないためにdicから削除
                            dic.remove(sb.toString());
                        }
                    }
                    // 元に戻す
                    sb.setCharAt(j, cur.charAt(j));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(s.ladderLength(
            "hit",
            "cog",
            Arrays.asList(wordList)
        ));
    }
}
