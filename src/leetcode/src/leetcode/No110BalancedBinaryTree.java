package leetcode;

import leetcode.common.TreeNode;

public class No110BalancedBinaryTree {

	public static void main(String[] args) {

	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
        if (root.left == null && root.right == null) {
        	return true;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        int heightGap = heightLeft - heightRight;
        return isBalanced(root.left) && isBalanced(root.right) && heightGap >= -1 && heightGap <= 1; 
    }
	
	public static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}
}
