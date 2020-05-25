package com.yfan.sparsearray;
/**
 * ϡ������
 * @author 3288609049
 *
 */
public class SparseArray {

	public static void main(String[] args) {
		int[][] chessArr1 = new int[11][11];
		chessArr1[1][2]=1;
		chessArr1[2][3]=2;
		//���ԭʼ�Ķ�ά����
		for (int[] row : chessArr1) {
			for (int  data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		//������ά���� �õ����������
		 int sum=0;
		 for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				if(chessArr1[i][j]!=0) {
					sum++;
				}
			}
		}
		 //����ϡ������
		 int[][] sparseArr=new int[sum+1][3];
		 //��ϡ�����鸳ֵ
		 sparseArr[0][0]=11;
		 sparseArr[0][1]=11;
		 sparseArr[0][2]=sum;
		 //������ά���齫�����������ӵ�ϡ������
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
		   //��ӡϡ������
		   System.out.println("ϡ������----------------------");
		   for (int i = 0; i < sparseArr.length; i++) {
			   System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
			
		}
		   System.out.println("^^^^^^^^^^^^^^^");
		   //ϡ������ת���ɶ�ά����
		   
		   int[][] chessArr2=new int [sparseArr[0][0]][sparseArr[0][1]];
		   
		   
		   for (int i = 1; i < sparseArr.length ; i++) {
			    chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
			
		}
		   //ϡ������ת����Ķ�ά����
		   for (int[] row : chessArr2) {
				for (int  data : row) {
					System.out.printf("%d\t",data);
				}
				System.out.println();
			}
		 
		 
		 

	}
}
