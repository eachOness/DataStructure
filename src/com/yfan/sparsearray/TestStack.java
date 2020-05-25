package com.yfan.sparsearray;

public class TestStack {
	public static void main(String[] args) {
 
	}

}
//定义一个简单的stack
class ArrayStack {
	private int maxSize;
	private int[] arrStack;
	private int top; // 栈顶

	public ArrayStack(int size) {
		this.maxSize = size;
		arrStack = new int[size];
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;

	}
	
	public void pushStack(int value) {
		if(isFull()) {
			System.out.println("栈已满");
			return;
		}
		top++;
		arrStack[top]=value;
	}
	
	public int pop() {
		if(isEmpty() ) {
			throw new RuntimeException("没有数据");
		}
		int val=arrStack[top];
		top--;
		return val;
	}
	
	public void list() {
		//遍历时需要从栈顶开始遍历
		if(isEmpty()) {
			throw new RuntimeException("没有数据");
		}
		for (int i = top; i>-1; i--) {
			System.out.printf("stack[%d]=%d\n",i,arrStack[i]);
			
		}
		
	}

}