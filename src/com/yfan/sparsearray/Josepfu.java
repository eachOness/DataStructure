package com.yfan.sparsearray;

public class Josepfu {

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

		circleSingleLinkedList.addBoy(25);
		//circleSingleLinkedList.showList();
		circleSingleLinkedList.countBoy(1, 2, 25);
	}

}

//����һ���������б�
class CircleSingleLinkedList {

	// ����һ��first ��ǰû�б��
	private Boy first = null;

	// ���һ���ڵ㹹���ɻ����б�

	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("�������븺��");
			return;
		}
		// ����ָ��
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			// ����ǵ�һ��С����
			if (1 == i) {
				first = boy;
				first.setNext(first); // ���ɻ����б�
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	// ������ǰ�����б�
	public void showList() {

		if (first == null) {
			System.out.println("������������û������");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.println("С���ı�ţ�" + curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext(); // curBoy�����
		}
	}

	// �����С���ĳ�Ȧ˳��
	public void countBoy(int startNo, int countNum, int nums) {

		// �����ݽ���У��
		if (first == null || startNo < 1 || startNo > nums) {

			System.out.println("����������� ����������");
			return;
		}
		Boy helper = first;
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		for (int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		while (true) {
			if (helper == first) {
				break; // Ȧ��ֻ��һ���� ֹͣ

			}

			for (int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("С��%d\n�ѳ�Ȧ", first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("�������Ȧ�е�С�����%d\n", helper.getNo());
	}
}

class Boy {

	private int no;
	private Boy next;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

	public Boy(int no) {

		this.no = no;
	}

}
