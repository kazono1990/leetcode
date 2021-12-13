package jp.co.kazono.leetcode.LC0095_Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        List<TreeNode> leftNodes;
        List<TreeNode> rightNodes;

        for (int i = start; i <= end; i++) {
            leftNodes = genTrees(start, i - 1);
            rightNodes = genTrees(i + 1, end);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateTrees(3);
    }
}
