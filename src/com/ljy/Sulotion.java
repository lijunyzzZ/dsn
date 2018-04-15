package com.ljy;
/**
 * 栈实现min函数
 * 
 */
import java.util.Stack;

public class Sulotion {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int node) {
		stack.push(node);
		if (minStack.isEmpty()||minStack.peek().intValue()>node) {
			minStack.push(node);
		} else if (minStack.peek().intValue() < node) {
			minStack.push(minStack.peek());
		}

	}

	public void pop() {
		if (!stack.isEmpty()) {
			stack.pop();
		}
		if (!minStack.isEmpty()) {
			minStack.pop();
		}
	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		return 0;
	}

	public int min() {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		return 0;
	}
}
