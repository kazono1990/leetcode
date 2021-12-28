package jp.co.kazono.leetcode.LC0109_Convert_Sorted_List_to_Binary_Search_Tree;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;

        // find middle node
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head, slow);
        node.right = helper(slow.next, tail);
        return node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // init ListNode
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }

        ListNode head = dummy.next;
        TreeNode bst = s.sortedListToBST(head);
    }
}
