package com.yfan.tree;
/**
 * 有序二叉树
 * @author 3288609049
 *
 */
public class ArrBinaryTree {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrBinaryTree1 arrBinaryTree1 = new ArrBinaryTree1(arr);
		arrBinaryTree1.midOrder(0);
	}

}

class ArrBinaryTree1 {

	private int[] arr;

	public ArrBinaryTree1(int[] arr) {
		super();
		this.arr = arr;
	}

	public void preOrder(int n) {

		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}
		System.out.print(arr[n] + ",");
		// 左子树节点
		if ((n * 2 + 1) < arr.length) {
			preOrder(2 * n + 1);

		}
		// 右子树节点
		if ((n * 2 + 2) < arr.length) {
			preOrder(2 * n + 2);

		}

	}
	  //中续遍历
	public void midOrder(int n) {

		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}

		// 左子树节点
		if ((n * 2 + 1) < arr.length) {
			midOrder(2 * n + 1);

		}
		System.out.print(arr[n] + ",");
		// 右子树节点
		if ((n * 2 + 2) < arr.length) {
			midOrder(2 * n + 2);

		}

	}
  //后续遍历
	public void postOrder(int n) {

		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}

		// 左子树节点
		if ((n * 2 + 1) < arr.length) {
			postOrder(2 * n + 1);

		}

		// 右子树节点
		if ((n * 2 + 2) < arr.length) {
			postOrder(2 * n + 2);

		}
		System.out.print(arr[n] + ",");
	}
}