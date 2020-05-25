package com.yfan.tree;

import java.util.Arrays;

/**
 * ������ ��length/2��-1 �������ķ�Ҷ�ӽڵ�
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
		int temp = 0; // �󶥶� �����һ��Ҷ�ӽڵ㽻��
		System.out.println("������ ");

		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjupHeap(arr, i, arr.length);
		}

		for (int j = arr.length - 1; j > 0; j--) {

			temp = arr[j]; // ����
			arr[j] = arr[0];
			arr[0] = temp;
			adjupHeap(arr, 0, j);
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void adjupHeap(int[] arr, int i, int length) {
		int temp = arr[i]; // ȡ����ǰ��Ҷ�ӽڵ��ֵ

		for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				k++; // ָ�����ӽڵ�
			}

			if (arr[k] > temp) { // ˵���ӽڵ���ڸ��ڵ�
				arr[i] = arr[k]; // �ϴ���ӽڵ�͸��ڵ㽻�� ���������ӽڵ�͸��ڵ�ͻ���
				i = k; // iָ��k����ѭ���Ƚ�
			} else {
				break;
			}

		}
		arr[i] = temp;
	}

}
