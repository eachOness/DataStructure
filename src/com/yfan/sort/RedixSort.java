package com.yfan.sort;

import java.util.Arrays;

/**
 * 基数排序
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
		// 得到数组种的最大值
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// 得到最大的位数
		int maxLength = (max + "").length();
		for (int j = 0, n = 1; j < maxLength; j++, n *= 10) {
			int[][] bucket = new int[10][arr.length];
			int[] bucketElementCount = new int[10];
			for (int i = 0; i < arr.length; i++) {
				// 取出每个元素的个位值
				int dig = arr[i] / n % 10;
				bucket[dig][bucketElementCount[dig]] = arr[i];
				bucketElementCount[dig]++;
			}
			// 按照桶的顺序（一位数组的下标一次取出数据，放入原来的桶中）
			int index = 0;
			for (int k = 0; k < bucketElementCount.length; k++) {

				if (bucketElementCount[k] != 0) {

					for (int l = 0; l < bucketElementCount[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				// 每进行一轮将桶中的数据个数清为0
				bucketElementCount[k] = 0;
			}
			System.out.printf("第%d轮，对个位的排序处理为=%s\n",j+1,Arrays.toString(arr));
		}

	}

}
