package com.yfan.hashtable;

/**
 * hash��
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

	// ���
	public void add(Emp emp) {
		int empLinkedListNo = hashFun(emp.id);
		// ��emp��ӵ���Ӧ��������
		empLinkedList[empLinkedListNo].add(emp);

	}

	/**
	 * �������е�hash��
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
			System.out.println("�Ҳ���������������");
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
			System.out.println("��" + no + "����Ϊ��");
			return;
		}
		System.out.print("��ǰ�������ϢΪ");

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
			System.out.println("����Ϊ��");
			return null;
		}
		Emp curEmp = head;

		while (true) {
			if (curEmp.next == null) {
				break;
			}
			if (curEmp.id == id) {

				System.out.println("�ҵ���");
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;

	}

}
