package com.ljy;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 
 * @author 李君易
 *
 */
public class StackFile {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		if(this.stack2.empty()){
			stack2.push(node);
			stack1.push(node);
		}
		else {
			stack1.clear();
			while(!stack2.isEmpty()&&stack2.peek()!=null){
				stack1.push(stack2.pop());
			}
			stack1.push(node);
			stack2.clear();
			while(!stack1.isEmpty()&&stack1.peek()!=null){
				stack2.push(stack1.pop());
			}
		}
	}

	public int pop() {
		return this.stack2.pop();
	}
	public static void main(String[]args){
		StackFile s = new StackFile();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.stack2);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(4);
		System.out.println(s.pop());
	}

}
