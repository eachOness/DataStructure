package com.yfan.recursion;

/**
 * 八皇后问题
 * 
 * @author 3288609049
 *
 */
public class Queen8 {

	int[] array = new int[8];
  static int count=0;
	public static void main(String[] args) {
		Queen8 queen8=new Queen8();
				queen8.check(0);
				System.out.println("一共有"+count+"种解法");

	}

	public void check(int n) {
		if (n == 8) {
			print();
			return;
		}

		for (int i = 0; i < 8; i++) {
			array[n] = i;
			if (judge(n)) {
				check(n + 1);

			}
		}

	}

	public boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;

			}
		}
		return true;
	}

	public void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
