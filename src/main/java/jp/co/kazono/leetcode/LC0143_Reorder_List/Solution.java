package jp.co.kazono.leetcode.LC0143_Reorder_List;

public class Solution {

    public void reorderList(ListNode head) {
        // get middle node.
        /// if list is 1 -> 2 -> 3 -> 4, then return 2.
        ListNode middleNode = getMiddleNode(head);
        // nextToMiddleNode : 3 -> 4
        ListNode nextToMiddleNode = middleNode.next;

        // head : 1 -> 2
        middleNode.next = null;
        // p2 : 4 -> 3
        ListNode p2 = reverseList(nextToMiddleNode);

        ListNode p1 = head, tmp;
        while (p1 != null && p2 != null) {
            tmp = p1.next;
            p1.next = p2;
            p1 = p2;
            p2 = tmp;
        }
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    private ListNode generateList(int num) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int i = 1; i <= num; i++) {
            ListNode node = new ListNode(i);
            dummy.next = node;
            dummy = dummy.next;
        }
        return curr.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = s.generateList(4);
        s.reorderList(head);
    }
}
