package jp.co.kazono.leetcode.LC0092_Reverse_Linked_List_II;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode cur = head, prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            right--;
            left--;
        }

        ListNode con = prev, tail = cur;
        ListNode tmp = null;
        while (right > 0) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            right--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
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
        ListNode node4 = new ListNode(5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        s.printNode(s.reverseBetween(head, 2, 4));
    }
}
