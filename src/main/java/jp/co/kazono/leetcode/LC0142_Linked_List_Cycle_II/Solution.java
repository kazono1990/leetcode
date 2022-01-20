package jp.co.kazono.leetcode.LC0142_Linked_List_Cycle_II;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode search = head;
                while (slow != search) {
                    slow = slow.next;
                    search = search.next;
                }
                return search;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(3);
        ListNode node_1 = new ListNode(2);
        ListNode node_2 = new ListNode(0);
        ListNode node_3 = new ListNode(4);
        ListNode tail = new ListNode(1);

        head.next = node_1;
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = tail;
        tail.next = node_1;

        System.out.println(s.detectCycle(head).val);
    }
}
