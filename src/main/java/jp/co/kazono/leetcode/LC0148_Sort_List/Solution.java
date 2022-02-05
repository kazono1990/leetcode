package jp.co.kazono.leetcode.LC0148_Sort_List;

public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
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
        ListNode sortedList = s.sortList(head);
        s.printList(sortedList);
    }
}
