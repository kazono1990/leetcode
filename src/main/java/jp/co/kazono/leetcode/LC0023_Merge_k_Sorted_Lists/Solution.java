package jp.co.kazono.leetcode.LC0023_Merge_k_Sorted_Lists;

import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode list : lists) {
            if (list != null) queue.add(list);
        }

        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;

            if (curr.next != null) {
                queue.add(curr.next);
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
        ListNode list1 = s.generateList(new int[]{1, 4, 5});
        ListNode list2 = s.generateList(new int[]{1, 3, 4});
        ListNode list3 = s.generateList(new int[]{2, 6});
        ListNode[] lists = new ListNode[]{list1, list2, list3};
        ListNode mergedList = s.mergeKLists(lists);
        s.printList(mergedList);
    }
}
