package jp.co.kazono.leetcode.LC0876_Middle_of_the_Linked_List;

public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode generateList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }

    private void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while(head != null) {
            sb.append(head.val + " ");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums_1 = new int[]{1, 2, 3, 4, 5};
        ListNode head_1 = s.generateList(nums_1);
        s.printList(head_1);
        // [1, 2, 3]
        s.printList(s.middleNode(head_1));

        int[] nums_2 = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head_2 = s.generateList(nums_2);
        s.printList(head_2);
        // [4, 5, 6]
        s.printList(s.middleNode(head_2));
    }
}
