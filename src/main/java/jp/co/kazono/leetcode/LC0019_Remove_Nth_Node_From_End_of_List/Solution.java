package jp.co.kazono.leetcode.LC0019_Remove_Nth_Node_From_End_of_List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode a = newHead;
        ListNode b = newHead;
        while (n > 0) {
            b = b.next;
            n--;
        }
        while (b.next != null) {
            b = b.next;
            a = a.next;
        }
        a.next = a.next.next;
        return newHead.next;
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
        ListNode node_5 = new ListNode(5);
        ListNode node_4 = new ListNode(4, node_5);
        ListNode node_3 = new ListNode(3, node_4);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode head = new ListNode(1, node_2);

        printNode(head);
        Solution s = new Solution();
        s.removeNthFromEnd(head, 3);
        printNode(head);
    }
}
