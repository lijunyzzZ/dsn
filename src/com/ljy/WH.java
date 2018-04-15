package com.ljy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WH {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}

	}

	public static boolean Find(int target, int[][] array) {
		int width = array.length;
		int height = array[0].length;
		if (width == 0 || height == 0) {
			return false;
		}
		if (target < array[0][0] && target > array[height - 1][width - 1]) {
			return false;
		}
		for (int i = 0; i < width; i++) {
			if (target == array[width - i - 1][0]) {
				return true;
			}
			if (target < array[width - i - 1][0]) {
				continue;
			}
			for (int j = 0; j < height; j++) {
				if (target == array[width - i - 1][j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static String replaceSpace(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");
	}

	/**
	 * 输入一个链表的值
	 * 
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<>();
		if (listNode == null) {
			return result;
		}
		result.add(listNode.val);
		while (listNode.next != null) {
			listNode = listNode.next;
			result.add(listNode.val);
		}
		Collections.reverse(result);
		return result;
	}

	/**
	 * 输入一个链表，输出该链表中倒数第k个结点
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}
		List<ListNode> result = new ArrayList<>();
		result.add(head);
		ListNode inext = head;
		while (inext.next != null) {
			inext = inext.next;
			result.add(inext);
		}
		if (k > result.size()) {
			return null;
		}
		return result.get(result.size() - k);
	}

	/**
	 * 输入一个链表，反转链表后，输出链表的所有元素。
	 * 
	 * @param head
	 * @return
	 */
	// public static ListNode ReverseList(ListNode head) {
	// if (head == null) {
	// return null;
	// }
	// List<ListNode> result = new ArrayList<>();
	// result.add(head);
	// ListNode root = head;
	// while (root.next != null) {
	// root = root.next;
	// result.add(root);
	// }
	// int i = result.size();
	// System.out.print(result.get(i-1).val);
	// for (int j = 0; j < i-1; j++) {
	//// result.get(i - j -1).next = result.get(i - j - 2);
	// System.out.print(result.get(i - j-2).val);
	// }
	// return result.get(i-1);
	// }
	public static ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = head;
		ListNode cur = pre.next;
		ListNode tmp;
		while (cur != null) {
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		head.next = null;
		System.out.print(cur.val);
		System.out.print(pre.val);
		while (pre.next != null) {
			pre = pre.next;
			System.out.print(pre.val);
		}

		return pre;
	}
	/**
	 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ListNode Merge(ListNode list1, ListNode list2) {
		if(list1 == null){
			return list2;
		}
		if(list2 == null){
			return list1;
		}
		ListNode pre = list1;
		ListNode result = pre;
		ListNode cur = pre.next;
		ListNode demo = list2;
		ListNode tmp;
		while(pre != null){
			if(cur == null){
				pre.next = demo;
				break;
			}
			
			if(demo!=null&&demo.val>= pre.val&&demo.val<=cur.val){
				pre.next = demo;
				tmp = demo.next;
				demo.next = cur;
				pre = demo;
				demo = tmp;
			}else{
				pre = cur;
				cur = cur.next;
			}
			
		}
		return result;

	}

	public static void main(String[] args) {
		// int target = 7;
		// int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
		// { 6, 8, 11, 15 } };
		// Find(target, array);
		// StringBuffer str = new StringBuffer("wy hah");
		// System.out.println(replaceSpace(str));
		// int[] a = { 2, 2, 2, 2, 21, 2 };
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(5);
		ListNode head2= new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(5);
		Merge(head,head2);
	}

}
