package com.yfan.search;

import java.util.Arrays;

/**
 * ≤Â÷µ≤È’“
 * 
 * @author 3288609049
 *
 */
public class InsertSearch {
	public static void main(String[] args) {

		int[] arr = new int[100];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		int insertSearch = insertSearch(arr,0,arr.length-1,2);
		System.out.println("index="+insertSearch);
	}

	public static int insertSearch(int[] arr, int left, int right, int findVal) {
		int count=1;
		System.out.println(count++);

		if (left > right || findVal <arr[0] || findVal > arr[arr.length-1]) {
			return -1;
		}
		
		int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
		int midVal=arr[mid]; 
		
		if(findVal>midVal) {
			return insertSearch(arr, mid+1, right, findVal);
			
			
		}else if(findVal<midVal) {
			return insertSearch(arr, left, mid-1, findVal);
			
		}else {
			return mid;
		}
		
	}
}
