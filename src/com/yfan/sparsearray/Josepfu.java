package com.yfan.sparsearray;

public class Josepfu {

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

		circleSingleLinkedList.addBoy(25);
		//circleSingleLinkedList.showList();
		circleSingleLinkedList.countBoy(1, 2, 25);
	}

}

//创建一个单向环形列表
class CircleSingleLinkedList {

	// 创建一个first 当前没有编号
	private Boy first = null;

	// 添加一个节点构建成环形列表

	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("不能输入负数");
			return;
		}
		// 辅助指针
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			// 这个是第一个小孩子
			if (1 == i) {
				first = boy;
				first.setNext(first); // 构成环形列表
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	// 遍历当前环形列表
	public void showList() {

		if (first == null) {
			System.out.println("环形链表里面没有数据");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.println("小孩的编号：" + curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext(); // curBoy向后移
		}
	}

	// 计算初小孩的出圈顺序
	public void countBoy(int startNo, int countNum, int nums) {

		// 对数据进行校验
		if (first == null || startNo < 1 || startNo > nums) {

			System.out.println("输入参数错误 请重新输入");
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
				break; // 圈中只有一个人 停止

			}

			for (int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("小孩%d\n已出圈", first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后留在圈中的小孩编号%d\n", helper.getNo());
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
