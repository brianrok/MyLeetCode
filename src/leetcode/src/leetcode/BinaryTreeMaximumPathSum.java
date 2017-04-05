package leetcode;

import leetcode.common.TreeNode;

public class BinaryTreeMaximumPathSum {
    private static int currentMax = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        currentMax = Integer.MIN_VALUE;
        maxPathSumContainsRoot(root);
        return currentMax;
    }

    private static int maxPathSumContainsRoot(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int res = Integer.MIN_VALUE;
        int leftMax = 0;
        int rightMax = 0;
        if (root.left != null) {
            leftMax = maxPathSumContainsRoot(root.left);
            res = res > leftMax ? res : leftMax;
        }
        if (root.right != null) {
            rightMax = maxPathSumContainsRoot(root.right);
            res = res > rightMax ? res : rightMax;
        }
        if (res > currentMax) {
            currentMax = res;
        }
        if (res == Integer.MIN_VALUE) {
            res = root.val;
        } else {
            res += root.val;
        }
        if (root.val > res) {
            res = root.val;
        }
        if (res > currentMax) {
            currentMax = res;
        }
        if (root.val + leftMax + rightMax > currentMax) {
            currentMax = root.val + leftMax + rightMax;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, -2, -3, 1, 3, -2, null, -1});
        System.out.println(maxPathSum(root));
    }
}
