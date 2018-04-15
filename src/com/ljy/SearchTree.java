package com.ljy;


/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author 李君易
 *
 */
public class SearchTree {
	public static  boolean VerifySquenceOfBST(int[] sequence) {
//		for(int i=0 ;i<sequence.length;i++)
//		{
//			System.err.print(sequence[i]+" ");
//		}
//		System.out.println();
		if(sequence.length == 0 || sequence.length == 1||sequence.length ==2){
			return true;
		}
		int tmp = sequence[sequence.length - 1];
		int index = 0;
		for (int i = 0; i < sequence.length - 1; i++) {
			if (sequence[i] < tmp && index == 0) {
				continue;
			} else {
				index = i-1;
				break;
			}
		}
		if(index == 0){
			return true;
		}
		System.out.println(index);
		for(int i = index+1;i<sequence.length -1;i++){
			if(sequence[i]<tmp){
				return false;
			}
		}
		int[] front = new int[index+1];
		for(int i = 0;i<index+1;i++){
			front[i] = sequence[i];
		}
		for (int i = 0; i < front.length; i++) {
			System.out.print(front[i]);
		}
		int[] after = new int [sequence.length-2-index];
		for(int i = index+1;i<sequence.length-2;i++){
			after[i-index-1] = sequence[i];
		}
		return VerifySquenceOfBST(after)&&VerifySquenceOfBST(front);
	}
	public static void main(String[] args){
		int [] a = {1,2,3,4,5};
		System.out.println(VerifySquenceOfBST(a));
	}
}
