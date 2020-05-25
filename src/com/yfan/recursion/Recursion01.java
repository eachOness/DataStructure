package com.yfan.recursion;

public class Recursion01 {
	public static void main(String[] args) {
		int test = test(4);
		System.out.println(test);
	}
  
	
	public static int  test(int n) {
		if(n==1) {
			
			return n;
			
		
		}else {
			
			return test(n-1)*n; //1* 2*3 *4
		}
		
	}
}
