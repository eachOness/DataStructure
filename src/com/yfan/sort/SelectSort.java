package com.yfan.sort;

import java.util.Arrays;

/**
 * —°‘Ò≈≈–Ú
 * 
 * @author 3288609049
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 73, 2,2 ,2};
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	
	}
	 public static void selectSort(int []arr) {
		 
		 for (int i = 0; i < arr.length-1; i++) {
			 int index=i;
			 int min =arr[i];
				for (int j = i+1;j < arr.length; j++) {
					if(min>arr[j] ) {
						min=arr[j];
						 index=j;
					}
				}
				if(index!=i) {
					arr[index]=arr[i];
					arr[i]=min;
				}
				
			
	 } 
	 }
}
