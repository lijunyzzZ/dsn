package com.ljy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;
import javax.swing.text.AbstractDocument.LeafElement;

/**
 * 旋转数组
 * 
 * @author 李君易
 *
 */
public class ArraySpin {
	public static int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return array[i + 1];
			}
		}
		return 0;
	}

	public int JumpFloor(int target) {
		if (target < 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		return JumpFloor(target - 1) + JumpFloor(target - 2);
	}

	public static int Fibonacci(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	/**
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * 
	 * @param n
	 * @return
	 */
	public static int NumberOf1(int n) {
		String s = Integer.toBinaryString(n);
		String news = s.replaceAll("1", "");
		int length = s.length() - news.length();
		return length;
	}

	/**
	 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double Power(double base, int exponent) {
		double sum = 1;
		for (int i = 0; i < Math.abs(exponent); i++) {
			sum = sum * base;
		}
		if (exponent < 0) {
			sum = 1 / sum;
		}
		return sum;
	}

	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
	 * 偶数和偶数之间的相对位置不变。
	 * 
	 * @param array
	 */
	public static void reOrderArray(int[] array) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		int len = array.length;
		if (len == 0) {
			return;
		}
		for (int i = 0; i < len; i++) {
			if (array[i] % 2 == 0) {
				list1.add(array[i]);
				continue;
			}
			list2.add(array[i]);
		}
		list2.addAll(list1);
		for (int i = 0; i < len; i++) {
			array[i] = list2.get(i);
		}

	}

	/**
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13
	 * 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 * 
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		boolean[][] indexArr = new boolean[matrix.length + 2][matrix[0].length + 2];
		for (int i = 0; i < indexArr.length; i++) {
			for (int j = 0; j < indexArr[0].length; j++) {
				if (i == 0 || i == indexArr.length - 1 || j == 0 || j == indexArr[0].length - 1) {
					indexArr[i][j] = false;
				} else {
					indexArr[i][j] = true;
				}
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		result.add(matrix[0][0]);
		if (matrix.length == 1 && matrix[0].length == 1) {
			return result;
		}
		if (matrix.length == 1) {
			for (int j = 1; j < matrix[0].length; j++) {
				result.add(matrix[0][j]);
			}
			return result;
		}
		if (matrix[0].length == 1) {
			for (int j = 1; j < matrix.length; j++) {
				result.add(matrix[j][0]);
			}
			return result;
		}
		indexArr[1][1] = false;
		int i = 1, j = 2;
		while (indexArr[i][j] || indexArr[i - 1][j] || indexArr[i + 1][j] || indexArr[i][j + 1] || indexArr[i][j - 1]) {
			if (!indexArr[i][j - 1] && indexArr[i][j + 1] && !indexArr[i - 1][j]) {
				result.add(matrix[i - 1][j - 1]);
				indexArr[i][j] = false;
				System.out.println(matrix[i - 1][j - 1]);
				j++;
				continue;
			} else if (indexArr[i][j - 1] && !indexArr[i][j + 1] && !indexArr[i + 1][j]) {
				result.add(matrix[i - 1][j - 1]);
				indexArr[i][j] = false;
				System.out.println(matrix[i - 1][j - 1]);
				j--;
				continue;
			} else if (!indexArr[i][j + 1] && indexArr[i + 1][j]) {
				result.add(matrix[i - 1][j - 1]);
				indexArr[i][j] = false;
				System.out.println(matrix[i - 1][j - 1]);
				i++;
				continue;
			} else {
				result.add(matrix[i - 1][j - 1]);
				indexArr[i][j] = false;
				System.out.println(matrix[i - 1][j - 1]);
				i--;
				continue;

			}
		}
		return result;
	}

	public static int MoreThanHalfNum_Solution(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (res.get(array[i]) == null) {
				res.put(array[i], 1);
			} else {
				res.put(array[i], res.get(array[i]) + 1);
			}
			System.err.println(res.get(2));
			System.out.println(array.length / 2);
			if (i > array.length / 2 - 1 && res.get(array[i]) > array.length / 2) {
				return array[i];
			}
		}
		return 0;
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (input.length == 0 || k > input.length) {
			return result;
		}
		for (int i = 0; i < input.length; i++) {
			result.add(input[i]);
		}
		Collections.sort(result);
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(result.get(i));
		}
		Collections.sort(result);
		return res;
	}

	/**
	 * 子向量
	 * 
	 * @param array
	 * @return
	 */
	public static int FindGreatestSumOfSubArray(int[] array) {
		ArrayList<Integer> res = new ArrayList<>();
		if (array.length == 0) {
			return 0;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				int sum = sum(array, i, j);
				res.add(sum);
			}
		}
		Collections.sort(res);
		return res.get(res.size() - 1);
	}

	public static int sum(int[] a, int i, int j) {
		if (i == j) {
			return a[i];
		}
		int sum = 0;
		if (i > j) {
			int tmp = i;
			i = j;
			j = tmp;
		}
		for (int x = i; x <= j; x++) {
			sum += a[x];
		}
		return sum;
	}

	/**
	 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、
	 * 13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
	 * 
	 * @param args
	 */
	public static int NumberOf1Between1AndN_Solution(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += getTm(i);
		}
		return sum;
	}

	public static int getTm(int n) {
		String str = Integer.toString(n);
		int a = str.length();
		int b = str.replaceAll("1", "").length();
		return str.length() - str.replaceAll("1", "").length();
	}

	public static void main(String[] args) {
		// int[] a = { 3, 4, 5, 1, 2 };
		// // System.out.println(minNumberInRotateArray(a));
		// System.out.println(Fibonacci(39));
		// System.out.println(Fibonacci(4));
		// System.out.println(Fibonacci(2));
		// reOrderArray(a);
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i]);
		// }
		// System.out.println(Power(1.9, 2));
		// int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, {
		// 13, 14, 15, 16 } };
		// int[][] arr1 = { { 1, 2 }, { 3, 4 } };
		// int[][] arr2 = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		// System.out.println(printMatrix(arr2).toArray());
		// int[] a = { 2, 2, 2, 2, 2, 1, 3, 4, 5 };
		// System.out.println(MoreThanHalfNum_Solution(a));

		// int[] a = { 2, 8, 1, 5, 9 };
		// System.out.println(FindGreatestSumOfSubArray(a));

		int n = 13;
		System.out.println(NumberOf1Between1AndN_Solution(n));

	}

}
