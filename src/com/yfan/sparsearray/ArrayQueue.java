package com.yfan.sparsearray;
/**
 * ����
 * @author 3288609049
 *
 */
public class ArrayQueue {
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
	}
}


class ArrayQueueT {
	   private int maxSize; //��������
	   private  int fornt;  //����ͷ
	   private  int rear;    //����β��
	   private int [] array;  //����������ģ�����
	   
	   public ArrayQueueT(int maxSize) {
		   this.maxSize=maxSize;
		   fornt=-1;  
		   rear=-1;
		   array=new int[maxSize];
		   
	   }
	    //�����Ƿ�����
	   public boolean  isFull() {
		   
		   return rear==maxSize-1;
	   }
	     //�����Ƿ�Ϊ��
	   	public boolean  isEmpty() {
		   
		   return rear==fornt;
	   }
	   	 //��Ӷ���
	   	public void addQueue(int n) {
	   		if(isFull()) {
	   			System.out.println("�������� �������");
	   			return;
	   			
	   		}
	   		array[++rear]=n;
	   	}
	   	//������
	   	public int getQueue( ) {
	   		if(isEmpty()) {
	   			System.out.println("�����ǿյĲ���ȡ����ֵ");
	   			return -1;
	   		}
	   		return  array[++fornt] ;
	   	}
	   	//��ʾ���е���������
	   	
	   	public void showQueue() {
	   		if(isEmpty() ) {
	   			
	   			System.out.println("����Ϊ��");
	   		}
	   		 for (int i = 0; i < array.length; i++) {
				System.out.println("-"+array[i]);
			}
	   		
	   	}
	
}