package com.ljy;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * @author 李君易
 *
 */
public class TreeA {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> a = new ArrayList<>();
		if (root == null)
			return a;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		a.add(root.val);
		TreeNode current = null;
		while (!queue.isEmpty()) {
			current = queue.poll();
			if(current != root){
				a.add(current.val);
			}
			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}
		return a;
	}
	
}
