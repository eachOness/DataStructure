package com.yfan.sparsearray;
/**
 * 队列
 * @author 3288609049
 *
 */
public class ArrayQueue {
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
	}
}


class ArrayQueueT {
	   private int maxSize; //最大的容量
	   private  int fornt;  //队列头
	   private  int rear;    //队列尾部
	   private int [] array;  //用与存放数据模拟队列
	   
	   public ArrayQueueT(int maxSize) {
		   this.maxSize=maxSize;
		   fornt=-1;  
		   rear=-1;
		   array=new int[maxSize];
		   
	   }
	    //队列是否满了
	   public boolean  isFull() {
		   
		   return rear==maxSize-1;
	   }
	     //队列是否为空
	   	public boolean  isEmpty() {
		   
		   return rear==fornt;
	   }
	   	 //添加队列
	   	public void addQueue(int n) {
	   		if(isFull()) {
	   			System.out.println("队列已满 不能添加");
	   			return;
	   			
	   		}
	   		array[++rear]=n;
	   	}
	   	//出队列
	   	public int getQueue( ) {
	   		if(isEmpty()) {
	   			System.out.println("队列是空的不能取出来值");
	   			return -1;
	   		}
	   		return  array[++fornt] ;
	   	}
	   	//显示队列的所有数据
	   	
	   	public void showQueue() {
	   		if(isEmpty() ) {
	   			
	   			System.out.println("队列为空");
	   		}
	   		 for (int i = 0; i < array.length; i++) {
				System.out.println("-"+array[i]);
			}
	   		
	   	}
	
}