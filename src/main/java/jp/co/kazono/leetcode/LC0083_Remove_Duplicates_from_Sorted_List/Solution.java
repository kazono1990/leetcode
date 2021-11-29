package jp.co.kazono.leetcode.LC0083_Remove_Duplicates_from_Sorted_List;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode list = head;
        while (list.next != null) {
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }
        return head;
    }

    public void printNode(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node.next != null) {
            sb.append(node.val + " -> ");
            node = node.next;
        }
        sb.append(node.val);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode node4 = new ListNode(3);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(1, node1);

        s.printNode(s.deleteDuplicates(head));

    }
}
