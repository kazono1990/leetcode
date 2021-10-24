package jp.co.kazono.leetcode.LC0021_Merge_Two_Sorted_Lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }
        else if (l2 != null) {
            curr.next = l2;
        }

        return newHead.next;
    }

    public static void printNode(ListNode list) {
        ListNode curr = list;
        while (curr.next != null) {
            System.out.print(curr.val + " → ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }

    public static void main(String[] args) {
        ListNode l1_node_3 = new ListNode(4);
        ListNode l1_node_2 = new ListNode(2, l1_node_3);
        ListNode l1 = new ListNode(1, l1_node_2);

        ListNode l2_node_3 = new ListNode(4);
        ListNode l2_node_2 = new ListNode(3, l2_node_3);
        ListNode l2 = new ListNode(1, l2_node_2);

        Solution s = new Solution();
        ListNode merged_list = s.mergeTwoLists(l1, l2);
        printNode(merged_list);
    }
}
