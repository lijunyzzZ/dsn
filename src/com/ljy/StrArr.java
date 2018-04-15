package com.ljy;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,
 * bca,cab和cba。
 * 先输出记录str的直接顺序，然后最后一位和倒数第二位交换并记录，倒数第三位和第二位交换记录，每次执行方法都会add start == end时就相当于
 * 遍历完了就可以记录值正思逆序
 * @author 李君易
 *
 */
public class StrArr {
	public static  ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<>();
		TreeSet<String> res = new TreeSet<>();
		char[] a = str.toCharArray();
		getPermutation(res, a, 0, a.length - 1);
		result.addAll(res);
		return result;
	}

	public static void getPermutation(TreeSet<String> res, char[] a, int start, int end) {
		if (start == end) {
			res.add(String.valueOf(a));
		}
		else{
			for (int i = start; i <=end; i++) {
				swap(a, start, i);
				getPermutation(res, a, start + 1, end);
				swap(a, start, i);
			}
			
		}
	}

	public static void swap(char[] a, int i, int j) {
		if (i == j) {

		} else {
			char tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}
	public static void main(String[] args){
		Permutation("abcd");
	}
}
