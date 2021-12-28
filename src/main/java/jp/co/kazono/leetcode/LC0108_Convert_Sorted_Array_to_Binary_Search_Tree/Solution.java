package jp.co.kazono.leetcode.LC0108_Convert_Sorted_Array_to_Binary_Search_Tree;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode head = sortedArrayToBSTHelper(nums, 0, nums.length - 1);
        return head;
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, low, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, high);
        return node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode bst = s.sortedArrayToBST(nums);
    }
}
