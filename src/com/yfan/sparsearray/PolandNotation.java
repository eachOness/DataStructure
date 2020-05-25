package com.yfan.sparsearray;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �沨�����ʽ��ʵ�ּ�����
 * 
 * @author 3288609049
 *
 */
public class PolandNotation {

	public static void main(String[] args) {

		// �ȶ���һ���沨�����ʽ
		// (4+5)*5-6
//		String suffixExpression = "3 4 + 5 * 6 -";
//		// �Ƚ�"3 4 + 5 * 6 -" ����ArrayList ��
//
//		List<String> listString = getListString(suffixExpression);
//		System.out.println(listString);
//		System.out.println("��������" + cal(listString));

		String expression = "1+((2+3)*4)-5";
		List<String> tosuffixExpressionList = tosuffixExpressionList(expression);
		System.out.println(tosuffixExpressionList);
		System.out.println("-------------------------------------------------");

		List<String> paseSuffixExpression = paseSuffixExpression(tosuffixExpressionList);
		System.out.println(paseSuffixExpression);
		
		System.out.printf("1+((2+3)*4)-5=%d",cal(paseSuffixExpression));
		
		
	}

	/**
	 * ת��Ϊ��׺���ʽ
	 * 
	 * @param ls
	 * @return
	 */
	public static List<String> paseSuffixExpression(List<String> ls) {
		Stack<String> s1 = new Stack<String>();
		List<String> s2 = new ArrayList<>(); // �洢�м�Ľ��
		for (String item : ls) {
			if (item.matches("\\d+")) {
				s2.add(item);

			} else if (item.equals("(")) {
				s1.push(item);

			} else if (item.equals(")")) {
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop(); // ��s1�� ( ����
			} else {
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				// ����Ҫ��itemѹ�뵽ջ
				s1.push(item);
			}
		}
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2;
	}

	public static List<String> tosuffixExpressionList(String s) {
		List<String> list = new ArrayList<>();
		int i = 0;
		String str; // �Զ�λ��ƴ��
		char c; // ûɨ�赽һ���ַ��ʹ�ŵ�C��
		do {
			if ((c = s.charAt(i)) <= 47 || (c = s.charAt(i)) >= 58) {
				list.add(c + "");
				i++;
			} else {
				str = "";
				// ɨ���ǲ�������
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					str += c;
					i++;
				}
				list.add(str);
			}
		} while (i < s.length());

		return list;

	}

	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	public static int cal(List<String> ls) {
		Stack<String> stack = new Stack<>();

		for (String item : ls) {
			if (item.matches("\\d+")) { // ƥ����Ƕ�λ��

				stack.push(item);
			} else {
				// ���������� ����������ջ
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num2 - num1;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num1 / num2;
				} else {
					throw new RuntimeException("�Ҿ����׳��쳣");
				}
				stack.push(res + "");
			}
		}

		return Integer.parseInt(stack.pop());
	}
}

/**
 * ����������ȼ�
 * 
 * @author 3288609049
 *
 */
class Operation {
	private final static int ADD = 1; // +
	private final static int SUB = 1; // -
	private final static int MUL = 2; // *
	private final static int DIV = 2; // /

	public static int getValue(String operation) {
		int res = 0;
		switch (operation) {
		case "+":
			res = ADD;
			break;
		case "-":
			res = SUB;
			break;
		case "*":
			res = MUL;
			break;
		case "/":
			res = DIV;
			break;
		default:
			System.out.println("��ʱ��֧�������������");
			break;
		}
		return res;

	}

}
