package com.yfan.sparsearray;

@SuppressWarnings("all")
public class Calaulate {

	public static void main(String[] args) {
		String expression = "7+2"; //
		 
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char chr = ' '; // 每次扫描保存到chr中
		while (true) {
			chr = expression.substring(index, index + 1).charAt(0);
			if (operStack.isOper(chr)) {

				if (!operStack.isEmpty()) {

					if (operStack.priority(chr) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.calc(num1, num2, oper);
						
						numStack.pushStack(res);
						operStack.pushStack(chr);
					} else {
						operStack.pushStack(chr);
					}

				} else {
					// TO 如果为空直接入栈
					operStack.pushStack(chr);
				}

			} else {
				// 如果是数字则直接入数栈
				numStack.pushStack(chr - 48);
			}

			index++;
			if (index == expression.length()) {
				break;
			}
		}
		//当扫描完毕后 就顺序从数栈和符号栈pop出相应的符号和数字  并运行
		while (true) {

			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.calc(num1, num2, oper);
			numStack.pushStack(res);
		}
		int result=numStack.pop();
		System.out.printf("表达式%s=%d", expression, result);
	}

}

class ArrayStack2 {
	private int maxSize;
	private int[] arrStack;
	private int top; // 栈顶

	public ArrayStack2(int size) {
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
		if (isFull()) {
			System.out.println("栈已满");
			return;
		}
		top++;
		arrStack[top] = value;
	}

	// 返回当前的栈顶
	public int peek() {
		return arrStack[top];
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("没有数据---");
		}
		int val = arrStack[top];
		top--;
		return val;
	}

	public void list() {
		// 遍历时需要从栈顶开始遍历
		if (isEmpty()) {
			throw new RuntimeException("没有数据****");
		}
		for (int i = top; i > -1; i--) {
			System.out.printf("stack[%d]=%d\n", i, arrStack[i]);

		}

	}

	public int priority(int oper) {

		if (oper == '*' || oper == '/') {
			return 1;

		} else if (oper == '+' || oper == '-') {

			return 0;
		}

		else {
			return -1;
		}
	}

	// 判断是不是一个运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '/' || val == '*';
	}

	public int calc(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {

		case '-':
			res = num2 - num1;
			break;
		case '+':
			res = num1 + num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		case '*':
			res = num2 * num1;
			break;
		default:
			break;
		}
		return res;

	}

}