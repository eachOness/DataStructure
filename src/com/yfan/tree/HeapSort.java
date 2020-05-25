package com.yfan.tree;

import java.util.Arrays;

/**
 * 堆排序 （length/2）-1 左子树的非叶子节点
 * 
 * @author 3288609049
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] arr = { 4, 6, 8, 5, 9 ,-1,3,3};
		heapSort(arr);
	}

	public static void heapSort(int[] arr) {
		int temp = 0; // 大顶堆 和最后一个叶子节点交换
		System.out.println("堆排序 ");

		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjupHeap(arr, i, arr.length);
		}

		for (int j = arr.length - 1; j > 0; j--) {

			temp = arr[j]; // 交换
			arr[j] = arr[0];
			arr[0] = temp;
			adjupHeap(arr, 0, j);
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void adjupHeap(int[] arr, int i, int length) {
		int temp = arr[i]; // 取出当前非叶子节点的值

		for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				k++; // 指向右子节点
			}

			if (arr[k] > temp) { // 说明子节点大于父节点
				arr[i] = arr[k]; // 较大的子节点和父节点交换 （就是右子节点和父节点就换）
				i = k; // i指向k继续循环比较
			} else {
				break;
			}

		}
		arr[i] = temp;
	}

}
