package com.yfan.sparsearray;

public class TestStack {
	public static void main(String[] args) {
 
	}

}
//����һ���򵥵�stack
class ArrayStack {
	private int maxSize;
	private int[] arrStack;
	private int top; // ջ��

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
			System.out.println("ջ����");
			return;
		}
		top++;
		arrStack[top]=value;
	}
	
	public int pop() {
		if(isEmpty() ) {
			throw new RuntimeException("û������");
		}
		int val=arrStack[top];
		top--;
		return val;
	}
	
	public void list() {
		//����ʱ��Ҫ��ջ����ʼ����
		if(isEmpty()) {
			throw new RuntimeException("û������");
		}
		for (int i = top; i>-1; i--) {
			System.out.printf("stack[%d]=%d\n",i,arrStack[i]);
			
		}
		
	}

}