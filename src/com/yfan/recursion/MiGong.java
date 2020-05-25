package com.yfan.recursion;

public class MiGong {

	public static void main(String[] args) {
		int[][] map = new int[8][7];
		
		//����ȫ����Ϊ1  ����ǽ
		for (int i = 0; i < 7; i++) {
			map[0][i]=1;
			map[7][i]=1;
		}
		//����ȫ����Ϊ1  ����ǽ
         for (int i = 0; i < 8; i++) {
			 map[i][6]=1;
			 map[i][0]=1;
		}
         map[3][1]=1;
         map[3][2]=1;
         map[3][3]=1;
          //��ͼ���
         for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
         setWay(map ,1,1);
         System.out.println("С���߹�֮��ĵ�ͼ");
         for (int i = 0; i < 8; i++) {
 			for (int j = 0; j < 7; j++) {
 				System.out.print(map[i][j]+" ");
 			}
 			System.out.println();
 		}
	}
	
	
	/**
	 * 
	 * @param map  ��ʾ�ߵ�ͼ
	 * @param i    ���ĸ�λ�ÿ�ʼ��
	 * @param j
	 * @return   �Ƿ��ҵ�  �ҵ�Ϊ true  ����Ϊfalse
	 */
	public static  boolean setWay(int [][]map,int i,int j) {
		if(map[6][5]==2) {   //֤�����ҵ��յ�
			return true;
			
		}else {
			  if(map[i][j]==0) {  //֤������·��û���߹�
				  map[i][j]=2;  //��������·������
				  
				  if(setWay( map, i+1, j)) {   //������
					  return true;
					  
				  }else if(setWay( map, i, j+1)) {  //������
					  return true;
					  
				  }else if(setWay( map, i-1, j)) {  //������
					  return true;
					  
				  }else if(setWay( map, i, j-1)) {  //������
					  return true;
					  
				  }else {
					  map[i][j]=3;
					  return false;
				  }
				  
			  }else {
				  //ֻҪ���� ==0  ���ܾ��� 1��2��3
				  return false;
			  }
			
		}
		
		
	}

}
