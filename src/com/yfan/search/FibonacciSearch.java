package com.yfan.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 * 
 * @author 3288609049
 *
 */
public class FibonacciSearch {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 10, 89, 1000, 1234 };
		
		 
		int fibonacciSearch = fibonacciSearch(arr, 1234);
		System.out.println("index="+fibonacciSearch);
	}

	static int maxSize = 20;
	 
	public static int[] fib() {
		int fib[] = new int[maxSize];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib;
	}

	/**
	 * 
	 * @param a
	 * @param key 我们需要查找的关键码的值
	 * @return
	 */
	public static int fibonacciSearch(int[] a, int key) {

		int low = 0;
		int hight = a.length - 1;
		int f[] = fib();
		int k = 0; // 斐波那契数组的元素下标
		int mid = 0; // 存放中间值
		while (hight > f[k] - 1) {
			k++;
		}

		int[] temp = Arrays.copyOf(a, f[k]);

		for (int i = hight + 1; i < temp.length; i++) {
			temp[i] = a[hight];

		}
		// 找到我们的数的key
		while (low <= hight) {
			mid = low + f[k - 2] - 1;

			if (key < temp[mid]) {
				hight = mid - 1;
				k--;
			} else if (key > temp[mid]) {
				low = mid + 1;
				key -= 2;
			} else {

				if (mid <= hight) {
					return mid;
				} else {
					return hight;
				}
			}

		}
		return -1;
	}

}
