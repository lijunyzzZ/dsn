package com.ljy;

import java.util.Scanner;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,
 * 5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：
 * 这两个序列的长度是相等的）
 * 
 * @author 李君易
 *
 */
public class ArrList {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> s = new Stack<>();
		int popIndex = 0;
		for (int i = 0; i < popA.length; i++) {
			s.push(pushA[i]);
			while(!s.empty() && popA[i] == popA[popIndex] ){
				s.pop();
				popIndex++;
			}
		}
		return s.isEmpty();
		
	}
	public static void main(String[] args){
		int T = 0;
	    int n = 0;
	    int a = 0,b= 0,c=0,d=0;
	    Scanner s = new Scanner(System.in);
	    T= s.nextInt();
	    int [] arr = new int[T];
	    
	    for(int i=0;i<T;i++){
	    	n = s.nextInt();
	        int sum = 0;
	        for(int j = 0;j<n;j++){
	        	a = s.nextInt();
	            b = s.nextInt();
	            c = s.nextInt();
	            d = s.nextInt();
	            sum = sum + getPoint(a,b,c,d);
	        }
	        arr[i] = sum;
	    }
	    for(int i= 0;i<T;i++){
	    	System.out.println(arr[i]);
	    }
	    s.close();
	}
	public static int getPoint(int a,int b,int c,int d){
		return (d-b+1)*(c-a+1);
	}
}
