package jp.co.kazono.leetcode.LC0023_Swap_Nodes_in_Pairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmpNode = head.next;
        head.next = swapPairs(head.next.next);
        tmpNode.next = head;
        return tmpNode;
    }

    public static void printNode(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            System.out.print(curr.val + " → ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }

    public static void main(String[] args) {
        ListNode node_4 = new ListNode(4);
        ListNode node_3 = new ListNode(3, node_4);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode head = new ListNode(1, node_2);

        printNode(head);
        Solution s = new Solution();
        printNode(s.swapPairs(head));
    }
}
