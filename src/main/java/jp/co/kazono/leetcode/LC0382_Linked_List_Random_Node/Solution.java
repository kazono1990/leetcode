package jp.co.kazono.leetcode.LC0382_Linked_List_Random_Node;

import java.util.ArrayList;

public class Solution {

    private ArrayList<Integer> numRange = new ArrayList<>();

    public Solution(ListNode head) {
        while (head != null) {
            this.numRange.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int pick = (int)(Math.random() * this.numRange.size());
        return this.numRange.get(pick);
    }

    public static void main(String[] args) {
        ListNode node_3 = new ListNode(3);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode head = new ListNode(1, node_2);
        Solution s = new Solution(head);
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
    }
}
