package com.yfan.sort;

import java.util.Arrays;

/**
 * Ï£¶ûÅÅĞò
 * 
 * @author 3288609049
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = { 8, 9, 2, 7, 1, 3, 4, 5, 6, 0 };
		shellSort(arr);

	}
	/**
	 * Ï£¶ûÅÅĞò£¨½»»»·¨£©
	 * @param arr
	 */
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;

		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					System.out.println(j+"²½³¤Îª");
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;

					}

				}
			}
			System.out.println("Ï£¶ûÅÅĞòµÚ" + (++count) + "ÂÖ=" + Arrays.toString(arr));

		}

	}
	/**
	 * Ï£¶ûÅÅĞò£¨ÒÆÎ»·¨£©
	 * @param arr
	 */
	public static void shellSort2(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j=i;
				int temp=arr[j];
				if(arr[j]<arr[j-gap]) {
					while(j-gap>=0 &&temp<arr[j-gap]) {
						
						arr[j]=arr[j-gap];
						i-=gap;
						
					}
					arr[j]=temp;
				}
			}
			
		}

	}

}
