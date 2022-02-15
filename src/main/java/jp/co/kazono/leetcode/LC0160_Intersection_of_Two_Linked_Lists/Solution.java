package jp.co.kazono.leetcode.LC0160_Intersection_of_Two_Linked_Lists;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        // move headA and headB to the same start point
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while (lenB < lenA) {
            headA = headA.next;
            lenA--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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

    private ListNode join(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        while (list1.next != null) {
            list1 = list1.next;
        }
        list1.next = list2;
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

        int[] numsA = new int[]{4, 1};
        int[] numsB = new int[]{5, 6, 1};
        int[] intersects = new int[]{8, 4, 5};

        ListNode intersect = s.generateList(intersects);
        ListNode headA = s.join(s.generateList(numsA), intersect);
        ListNode headB = s.join(s.generateList(numsB), intersect);

        s.printList(headA); // [ 4 1 8 4 5 ]
        s.printList(headB); // [ 5 6 1 8 4 5 ]

        ListNode intersectedNode = s.getIntersectionNode(headA, headB);
        System.out.println(intersectedNode.val);
    }
}
