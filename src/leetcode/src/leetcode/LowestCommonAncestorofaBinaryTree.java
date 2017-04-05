package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode.common.TreeNode;

public class LowestCommonAncestorofaBinaryTree {

	public static void main(String[] args) {
		TreeNode root = TreeNode.build(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
		TreeNode result = lowestCommonAncestor(root, root.left.right.right, root.right.right);
		System.out.println(result.val);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        Map<String, String> map = new HashMap<>();
        map.clear();
        return left == null? right: right == null? left: root;
    }
}
