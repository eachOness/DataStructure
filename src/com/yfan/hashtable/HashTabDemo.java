package com.yfan.hashtable;

/**
 * hash表
 * @author 3288609049
 *
 */
public class HashTabDemo {
	public static void main(String[] args) {
		HashTab hashTab=new HashTab(7);
	 

	}

}

class HashTab {
	private EmpLinkedList[] empLinkedList;
	private int size;

	public HashTab(int size) {
		this.size = size;
		empLinkedList = new EmpLinkedList[size];

		for (int i = 0; i < size; i++) {
			empLinkedList[i] = new EmpLinkedList();
		}

	}

	// 添加
	public void add(Emp emp) {
		int empLinkedListNo = hashFun(emp.id);
		// 将emp添加到对应的链表中
		empLinkedList[empLinkedListNo].add(emp);

	}

	/**
	 * 遍历所有的hash表
	 */
	public void list() {
		for (int i = 0; i < size; i++) {

			empLinkedList[i].list(i);
		}

	}

	public void findByEmpId(int id) {
		int no = hashFun(id);
		Emp findByEmpId = empLinkedList[no].findByEmpId(id);

		if (findByEmpId != null) {
			System.out.printf("id=%d ,name=%s", findByEmpId.id, findByEmpId.name);

		} else {
			System.out.println("找不到………………");
		}

	}

	public int hashFun(int id) {
		return id % size;
	}
}

class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

class EmpLinkedList {
	private Emp head;

	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}
		Emp curEmp = emp;
		while (true) {
			if (curEmp.next == null) {
				break;

			}
			curEmp = curEmp.next;
		}

		curEmp.next = emp;
	}

	public void list(int no) {
		if (head == null) {
			System.out.println("地" + no + "链表为空");
			return;
		}
		System.out.print("当前链表的信息为");

		Emp curEmp = head;
		while (true) {
			System.out.printf("id=%d\tname=%s", curEmp.id, curEmp.name);
			if (curEmp.next == null) {
				break;

			}
			curEmp = curEmp.next;

		}
	}

	public Emp findByEmpId(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return null;
		}
		Emp curEmp = head;

		while (true) {
			if (curEmp.next == null) {
				break;
			}
			if (curEmp.id == id) {

				System.out.println("找到了");
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;

	}

}
