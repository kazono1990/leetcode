package jp.co.kazono.leetcode.LC0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int preorderIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorderIndex = 0;
        this.inorderMap = new HashMap<>();

        // build a hashmap to store value -> its index relations
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        System.out.println(preorderIndex + ", " + left + ", " + right);
        // if there are no elements to construct the tree
        if (left > right) {
            return null;
        }

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, this.inorderMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, this.inorderMap.get(rootValue) + 1, right);

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode binaryTree = s.buildTree(preorder, inorder);
    }
}
