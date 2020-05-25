package com.yfan.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ¶ş·Ö²éÕÒ
 * 
 * @author 3288609049
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 6, 8, 99, 6666 ,6666,6666,6666};

	  List<Integer> binarySearch2 = binarySearch2(arr, 0, arr.length - 1, 6666);
		System.out.println("binarySearch=" + binarySearch2);
	}

	public static int binarySearch(int[] arr, int left, int right, int serarchVal) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;

		int midVal = arr[mid];

		if (midVal < serarchVal) {

			return binarySearch(arr, mid + 1, right, serarchVal);
		} else if (midVal > serarchVal) {
			return binarySearch(arr, left, mid - 1, serarchVal);
		} else {
			return mid;
		}

	}

	public static List<Integer> binarySearch2(int[] arr, int left, int right, int serarchVal) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (midVal < serarchVal) {
			return binarySearch2(arr, mid + 1, right, serarchVal);
		} else if (midVal > serarchVal) {
			return binarySearch2(arr, left, mid - 1, serarchVal);
		} else {

			List<Integer> list = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {

				if (temp < 0 || arr[temp] != serarchVal) {
					break;
				}

				list.add(temp);
				--temp;
			}
			list.add(mid);
			temp = mid + 1;
			while (true) {

				if (temp > arr.length - 1 || arr[temp] != serarchVal) {
					break;
				}

				list.add(temp);
				++temp;
			}

			return list;
		}

	}
}
