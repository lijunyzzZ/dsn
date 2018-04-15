package com.ljy;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * @author 李君易
 *
 */
public class PrintTree {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		ArrayList<Integer> s = new ArrayList<>();
		s.add(root.val);
		GetPath(root,s, target-10, res);
		return res;
	}

	public static void GetPath(TreeNode root,ArrayList<Integer> s, int k, ArrayList<ArrayList<Integer>> res) {
		if (k < 0) {
			s.remove(s.size()-1);
			return;
		}
		if (root.left != null) {
			s.add(root.left.val);
			GetPath(root.left,s, k - root.left.val, res);
		}
		if (root.right != null && k > root.val) {
			s.add(root.right.val);
			GetPath(root.right,s, k - root.right.val, res);
		}
		if (k == 0 && root.left == null && root.right == null) {
			ArrayList<Integer> mycopy=new ArrayList<Integer>();
			mycopy=(ArrayList<Integer>) s.clone();
			res.add(mycopy);
		}
		s.remove(s.size()-1);
		return;
	}
	public static void main(String[]args){
		TreeNode a = new TreeNode(10);
		a.left = new TreeNode(5);
		a.right = new TreeNode(12);
		a.left.left = new TreeNode(4);
		a.left.right = new TreeNode(7);
		System.out.println(FindPath(a, 22));
		
	}
}
