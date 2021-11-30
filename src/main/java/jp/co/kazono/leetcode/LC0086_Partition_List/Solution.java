package jp.co.kazono.leetcode.LC0086_Partition_List;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode curr_1 = left;
        ListNode curr_2 = right;
        while (head != null) {
            if (head.val < x) {
                curr_1.next = head;
                curr_1 = head;
            } else {
                curr_2.next = head;
                curr_2 = head;
            }
            head = head.next;
        }
        curr_2.next = null; // remove loop.
        curr_1.next = right.next;
        return left.next;
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

    public ListNode createHead(int[] vals) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int val : vals) {
            ListNode node = new ListNode(val);
            curr.next = node;
            curr = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] vals = new int[]{1, 4, 3, 2, 5, 2};
        ListNode head = s.createHead(vals);
        s.printNode(head);
        s.printNode(s.partition(head, 3));
    }
}
