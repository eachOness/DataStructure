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
		char chr = ' '; // ÿ��ɨ�豣�浽chr��
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
					// TO ���Ϊ��ֱ����ջ
					operStack.pushStack(chr);
				}

			} else {
				// �����������ֱ������ջ
				numStack.pushStack(chr - 48);
			}

			index++;
			if (index == expression.length()) {
				break;
			}
		}
		//��ɨ����Ϻ� ��˳�����ջ�ͷ���ջpop����Ӧ�ķ��ź�����  ������
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
		System.out.printf("���ʽ%s=%d", expression, result);
	}

}

class ArrayStack2 {
	private int maxSize;
	private int[] arrStack;
	private int top; // ջ��

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
			System.out.println("ջ����");
			return;
		}
		top++;
		arrStack[top] = value;
	}

	// ���ص�ǰ��ջ��
	public int peek() {
		return arrStack[top];
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("û������---");
		}
		int val = arrStack[top];
		top--;
		return val;
	}

	public void list() {
		// ����ʱ��Ҫ��ջ����ʼ����
		if (isEmpty()) {
			throw new RuntimeException("û������****");
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

	// �ж��ǲ���һ�������
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