package com.yfan.sort;

import java.util.Arrays;

/**
 * ≤Â»Î≈≈–Ú
 * @author 3288609049
 *
 */
public class InsertSort {
	  public static void main(String[] args) {
		  int[] arr = { 5, 3, 1, 73, 2,2 ,2};
		  System.out.println(Arrays.toString(arr));
		  insertSort(arr);
		  System.out.println(Arrays.toString(arr));
		  
	}
	
	public static void insertSort(int[] arr ) {
		
		for (int i = 1; i < arr.length; i++) {
			int insertVal=arr[i];
			int insertIndex=i-1;
			
			while(insertIndex>=0 && insertVal<arr[insertIndex]) {
				arr[insertIndex+1]=arr[insertIndex];
				insertIndex--;
				
			}
			
			arr[insertIndex+1]=insertVal;
		}
		
	}

}
