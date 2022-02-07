package jp.co.kazono.leetcode.LC0147_Insertion_Sort_List;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preInsert = null, toInsert = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
            } else {
                toInsert = head.next;
                preInsert = dummy;
                while (preInsert.next.val < toInsert.val) {
                    preInsert = preInsert.next;
                }
                head.next = toInsert.next;
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }
        return dummy.next;
    }

    private ListNode generateList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int num : nums) {
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = node;
        }
        return dummy.next;
    }

    private void printList(ListNode head) {
        StringBuilder sb = new StringBuilder().append("[ ");
        while (head != null) {
            sb.append(head.val).append((" "));
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init list
        int[] nums = new int[]{4, 2, 1, 3};
        ListNode head = s.generateList(nums);
        s.printList(head);
        ListNode sortedList = s.insertionSortList(head);
        s.printList(sortedList);
    }
}
