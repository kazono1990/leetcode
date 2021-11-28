package jp.co.kazono.leetcode.LC0082_Remove_Duplicates_from_Sorted_List_II;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode curr = newHead;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                curr.next = head.next;
            } else {
                curr = curr.next;
            }
            head = head.next;
        }
        return newHead.next;
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

        ListNode node6 = new ListNode(5);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        s.printNode(s.deleteDuplicates(head));
    }
}
