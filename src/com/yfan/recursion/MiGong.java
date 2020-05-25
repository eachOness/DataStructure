package com.yfan.recursion;

public class MiGong {

	public static void main(String[] args) {
		int[][] map = new int[8][7];
		
		//上下全部置为1  代表墙
		for (int i = 0; i < 7; i++) {
			map[0][i]=1;
			map[7][i]=1;
		}
		//左右全部置为1  代表墙
         for (int i = 0; i < 8; i++) {
			 map[i][6]=1;
			 map[i][0]=1;
		}
         map[3][1]=1;
         map[3][2]=1;
         map[3][3]=1;
          //地图情况
         for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
         setWay(map ,1,1);
         System.out.println("小球走过之后的地图");
         for (int i = 0; i < 8; i++) {
 			for (int j = 0; j < 7; j++) {
 				System.out.print(map[i][j]+" ");
 			}
 			System.out.println();
 		}
	}
	
	
	/**
	 * 
	 * @param map  表示者地图
	 * @param i    从哪个位置开始找
	 * @param j
	 * @return   是否找到  找到为 true  否则为false
	 */
	public static  boolean setWay(int [][]map,int i,int j) {
		if(map[6][5]==2) {   //证明已找到终点
			return true;
			
		}else {
			  if(map[i][j]==0) {  //证明这条路还没有走过
				  map[i][j]=2;  //假设这条路可以走
				  
				  if(setWay( map, i+1, j)) {   //向下走
					  return true;
					  
				  }else if(setWay( map, i, j+1)) {  //向右走
					  return true;
					  
				  }else if(setWay( map, i-1, j)) {  //向上走
					  return true;
					  
				  }else if(setWay( map, i, j-1)) {  //向左走
					  return true;
					  
				  }else {
					  map[i][j]=3;
					  return false;
				  }
				  
			  }else {
				  //只要不是 ==0  可能就是 1，2，3
				  return false;
			  }
			
		}
		
		
	}

}
