package jp.co.kazono.leetcode.LC1305_All_Elements_in_Two_Binary_Search_Trees;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        List<Integer> res = new ArrayList<>();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {

            // check all left node in root1.
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }

            // check all left node in root2.
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val <= stack2.peek().val)) {
                root1 = stack1.pop();
                res.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = stack2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        List<Integer> elements = s.getAllElements(root1, root2);
        System.out.println(Arrays.toString(ArrayUtils.toPrimitive(elements.toArray(new Integer[elements.size()]))));

    }
}
