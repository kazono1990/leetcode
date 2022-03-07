package jp.co.kazono.leetcode.LC0173_Binary_Search_Tree_Iterator;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        TreeNode root_right = new TreeNode(15);
        root.right = root_right;
        root_right.left = new TreeNode(9);
        root_right.right = new TreeNode(20);

        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next()); // 3
        System.out.println(bSTIterator.next()); // 7
        System.out.println(bSTIterator.hasNext()); // True
        System.out.println(bSTIterator.next()); // 9
        System.out.println(bSTIterator.hasNext()); // True
        System.out.println(bSTIterator.next()); // 15
        System.out.println(bSTIterator.hasNext()); // True
        System.out.println(bSTIterator.next()); // 20
        System.out.println(bSTIterator.hasNext()); // False
    }
}
