package com.ljy;

public class Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static int getLevelNum(TreeNode root,int n){
		if(root == null){
			return n;
		}
		return getLevelNum(root.left,n+1)>getLevelNum(root.right,n+1)?getLevelNum(root.left,n+1):getLevelNum(root.left, n+1);
	}
	public static void getAllLevel(TreeNode root){
		if(root == null){
			return;
		}
		
		System.out.println(root.val);
		for(int i=1;i<4;i++){
			System.out.print(getLevelNode(root,i));
			System.out.println();
		}
	}
	public static String  getLevelNode(TreeNode root,int i){
		if(root == null||i<0){
			return "";
		}
		if(root!=null&&i==0){
			return  Integer.toString(root.val);
		}
		return getLevelNode(root.left, i-1)+getLevelNode(root.right, i-1);
	}
	
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(pre[0]);
		int i;
		int length = pre.length;
		if (length == 1) {
			return root;
		}

		for (i = 0; i < length; i++) {
			if (pre[0] == in[i])
				break;
		}
		int[] leftin = new int[i];
		for (int j = 0; j < i; j++) {
			leftin[j] = in[j];
		}
		int[] leftpre = new int[i];
		for (int j = 0; j < i; j++) {
			leftpre[j] = pre[j + 1];
		}

		root.left = reConstructBinaryTree(leftpre, leftin);
		if (length == i) {
			return null;
		}

		int[] rightin = new int[length - i - 1];
		for (int j = 0; j < length - i - 1; j++) {
			rightin[j] = in[j + i + 1];
		}
		int[] rightpre = new int[length - i - 1];
		for (int j = 0; j < length - i - 1; j++) {
			rightpre[j] = pre[j + i + 1];
		}
		root.right = reConstructBinaryTree(rightpre, rightin);
		return root;

	}
	/**
	 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if(root2 == null||root1 == null){
			return false;
		}
		boolean a = false;
		if(root1.val == root2.val)
		{
			if(root2.left == null && root2.right==null){
				return true;
			}
			if(root2.left !=null && root2.right!=null){
				a = HasSubtree(root1.left, root2.left)&&HasSubtree(root1.right, root2.right);
			}
			if(root2.left==null && root2.right!=null){
				a = HasSubtree(root1.right, root2.right);
			}
			if(root2.left != null && root2.right == null){
				a = HasSubtree(root1.left, root2.left);
			}
		
		}
		return HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2)||a;
	}
	/**
	 * 操作给定的二叉树，将其变换为源二叉树的镜像。
	 * @param root
	 */
	public void Mirror(TreeNode root) {
		if(root==null){
			return;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		Mirror(root.left);
		Mirror(root.right);
	}
	public static void main(String[] args) {
//		int[] a = { 1, 2, 4, 3, 5, 6 };
//		int[] b = { 4, 2, 1, 5, 3, 6 };
//		reConstructBinaryTree(a, b);
		TreeNode A = new TreeNode(1);
		TreeNode B = new TreeNode(2);
		TreeNode C = new TreeNode(3);
		TreeNode D = new TreeNode(4);
		TreeNode E = new TreeNode(5);
		TreeNode F = new TreeNode(6);
		TreeNode G = new TreeNode(7);
		TreeNode H = new TreeNode(8);
		TreeNode Z = new TreeNode(2);
		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;
		D.left = H;
		Z.left = new TreeNode(4);
		Z.right = new TreeNode(5);
//		System.out.println(HasSubtree(A, Z));
//		getAllLevel(A);
		System.out.println(getLevelNum(B,0));
	}

}
