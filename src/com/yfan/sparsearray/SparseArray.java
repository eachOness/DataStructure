package com.yfan.sparsearray;
/**
 * 稀疏数组
 * @author 3288609049
 *
 */
public class SparseArray {

	public static void main(String[] args) {
		int[][] chessArr1 = new int[11][11];
		chessArr1[1][2]=1;
		chessArr1[2][3]=2;
		//输出原始的二维数组
		for (int[] row : chessArr1) {
			for (int  data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		//遍历二维数组 得到非零的数据
		 int sum=0;
		 for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				if(chessArr1[i][j]!=0) {
					sum++;
				}
			}
		}
		 //创建稀疏数组
		 int[][] sparseArr=new int[sum+1][3];
		 //给稀疏数组赋值
		 sparseArr[0][0]=11;
		 sparseArr[0][1]=11;
		 sparseArr[0][2]=sum;
		 //遍历二维数组将非零的数据添加到稀疏数组
		 int count=0;
		   for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessArr1[i][j]!=0) {
					count++;
					sparseArr[count][0]=i;
					sparseArr[count][1]=j;
					sparseArr[count][2]=chessArr1[i][j];
				}
			}
		}
		   //打印稀疏数组
		   System.out.println("稀疏数组----------------------");
		   for (int i = 0; i < sparseArr.length; i++) {
			   System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
			
		}
		   System.out.println("^^^^^^^^^^^^^^^");
		   //稀疏数组转换成二维数组
		   
		   int[][] chessArr2=new int [sparseArr[0][0]][sparseArr[0][1]];
		   
		   
		   for (int i = 1; i < sparseArr.length ; i++) {
			    chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
			
		}
		   //稀疏数组转换后的二维数组
		   for (int[] row : chessArr2) {
				for (int  data : row) {
					System.out.printf("%d\t",data);
				}
				System.out.println();
			}
		 
		 
		 

	}
}
