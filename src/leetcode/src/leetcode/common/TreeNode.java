package leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    
    public TreeNode(int val) {
    	this.val = val;
    }

    public static TreeNode build(Integer[] description) {
    	if (description == null || description.length == 0) {
    		return null;
    	}
    	List<TreeNode> nodeContainer = new ArrayList<>();
    	for (int i = 0; i < description.length; i++) {
    		if (description[i] == null) {
    			nodeContainer.add(null);
    		} else {
    			nodeContainer.add(new TreeNode(description[i]));
    		}
    	}
    	TreeNode root = nodeContainer.get(0);
    	List<TreeNode> queue = new ArrayList<>();
    	queue.add(root);
    	nodeContainer.remove(0);
    	while(queue.size() > 0) {
    		TreeNode nodeCurrent = queue.get(0);
    		queue.remove(0);
    		if (nodeCurrent == null) {
    			continue;
    		}
    		if (nodeContainer.size() > 0) {
    			nodeCurrent.left = nodeContainer.get(0);
    			queue.add(nodeContainer.get(0));
    			nodeContainer.remove(0);
    		}
    		if (nodeContainer.size() > 0) {
    			nodeCurrent.right = nodeContainer.get(0);
    			queue.add(nodeContainer.get(0));
    			nodeContainer.remove(0);
    		}
    	}
        return root;
    }
    
    public String toString() {
    	return Integer.toString(val);
    }

    public static void main(String[] args) {
        build(new Integer[]{1, -2, -3, 1, 3, -2, null, -1});
    }
}
