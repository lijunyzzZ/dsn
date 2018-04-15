package com.ljy;

import java.util.ArrayList;

/**
 * 二叉搜索树转换为双向链表
 * 
 * @author 李君易
 *
 */
public class TreeToLinkedList {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	/**
	 * 将树中序遍历到arraylist里面然后改变指针的指向
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		if(pRootOfTree.left == null && pRootOfTree.right == null){
			return pRootOfTree;
		}
		ArrayList<TreeNode> res = new ArrayList<>();
		getTra(pRootOfTree, res);
		for(int i = 0;i<res.size();i++){
			if(i==0){
				res.get(i).left = null;
				res.get(i).right = res.get(i+1);
				continue;
			}
			if(i==res.size()-1){
				res.get(i).left = res.get(i-1);
				res.get(i).right = null;
				continue;
			}
			res.get(i).left = res.get(i-1);
			res.get(i).right = res.get(i+1);
			
		}
		return res.get(0);

	}
	public void  getTra(TreeNode root,ArrayList<TreeNode> res){
		if(root == null){
			return ;
		}
		getTra(root.left, res);
		res.add(root);
		getTra(root.right, res);
	}
}
