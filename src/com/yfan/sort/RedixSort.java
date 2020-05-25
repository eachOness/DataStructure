package com.yfan.sort;

import java.util.Arrays;

/**
 * ��������
 * 
 * @author 3288609049
 *
 */
@SuppressWarnings("all")
public class RedixSort {
	public static void main(String[] args) {
		int[] arr = { 53, 3, 542, 748, 14, 214 };
		redixSort(arr);
	}

	public static void redixSort(int[] arr) {
		int max = arr[0];
		// �õ������ֵ����ֵ
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// �õ�����λ��
		int maxLength = (max + "").length();
		for (int j = 0, n = 1; j < maxLength; j++, n *= 10) {
			int[][] bucket = new int[10][arr.length];
			int[] bucketElementCount = new int[10];
			for (int i = 0; i < arr.length; i++) {
				// ȡ��ÿ��Ԫ�صĸ�λֵ
				int dig = arr[i] / n % 10;
				bucket[dig][bucketElementCount[dig]] = arr[i];
				bucketElementCount[dig]++;
			}
			// ����Ͱ��˳��һλ������±�һ��ȡ�����ݣ�����ԭ����Ͱ�У�
			int index = 0;
			for (int k = 0; k < bucketElementCount.length; k++) {

				if (bucketElementCount[k] != 0) {

					for (int l = 0; l < bucketElementCount[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				// ÿ����һ�ֽ�Ͱ�е����ݸ�����Ϊ0
				bucketElementCount[k] = 0;
			}
			System.out.printf("��%d�֣��Ը�λ��������Ϊ=%s\n",j+1,Arrays.toString(arr));
		}

	}

}
