package jp.co.kazono.leetcode.LC0061_Rotate_List;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;

        // Get total length of ListNode and end node.
        int len = 1;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }

        // Get the len - (k % len) th node.
        for (int i = 1; i < len - (k % len); i++) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    public void printList(ListNode head) {
        System.out.print("[ ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("]");
    }

    public ListNode createListNode(int startValue, int maxValue) {
        ListNode head = new ListNode(startValue);
        ListNode cur = head;
        for (int i = startValue + 1; i <= maxValue; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.rotateRight(s.createListNode(1,5), 2));
        s.printList(s.rotateRight(s.createListNode(0, 2), 4));
    }
}
