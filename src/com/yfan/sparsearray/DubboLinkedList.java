package com.yfan.sparsearray;

/**
 * ˫������
 * 
 * @author 3288609049
 *
 */
public class DubboLinkedList {

	public static void main(String[] args) {

	}

}

class DubooLinked {
	// �ȳ�ʼ��һ���ڵ� ͷ�ڵ㲻Ҫ�� ��������洢������
	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead2() {
		return head;
	}

	// ����˫������
	public void showLinkedList() {

		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {

				break;
			}

			System.out.println(temp);
			// ���ڵ�������
			temp = temp.next;

		}
	}

	// ���һ���ڵ㵽˫���������
	public void add(HeroNode2 heroNode) {
		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}

		temp.next = heroNode;
		heroNode.pre = temp;

	}

	// �޸Ľڵ�
	public void update(HeroNode2 newheroNode) {
		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newheroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.nickName = newheroNode.nickName;
			temp.name = newheroNode.name;

		} else { // û�����޸�����ڵ�

			System.out.println("û���ҵ�����ڵ�");
		}

	}

	// ɾ���ڵ�
	public void del(int no) {

		if (head.next == null) {

			System.out.println("����Ϊ�գ�ɾ������");
		}
		HeroNode2 temp = head.next;
		boolean flag = false;

		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// �ҵ�
		if (flag) {
//				temp.next=temp.next.next;
			temp.pre.next = temp.next;

			if (temp.next != null) {

				temp.next.pre = temp.pre;
			}

		} else {
			System.out.println("ɾ���Ľڵ㲻����");
		}
	}
}

class HeroNode2 {

	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next; // ָ����һ���ڵ�
	public HeroNode2 pre; // ָ����һ���ڵ�

	public HeroNode2(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + " ]";
	}

}
