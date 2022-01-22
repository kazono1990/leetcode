package jp.co.kazono.leetcode.LC0141_Linked_List_Cycle;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(3);
        ListNode node_1 = new ListNode(2);
        ListNode node_2 = new ListNode(0);
        ListNode tail = new ListNode(4);

        head.next = node_1;
        node_1.next = node_2;
        node_2.next = tail;
        tail.next = node_1;

        System.out.println(s.hasCycle(head));
    }
}
