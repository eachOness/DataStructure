package com.yfan.sparsearray;

/**
 * 双向链表
 * 
 * @author 3288609049
 *
 */
public class DubboLinkedList {

	public static void main(String[] args) {

	}

}

class DubooLinked {
	// 先初始化一个节点 头节点不要动 不妨具体存储的数据
	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead2() {
		return head;
	}

	// 遍历双向链表
	public void showLinkedList() {

		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {

				break;
			}

			System.out.println(temp);
			// 将节点往后移
			temp = temp.next;

		}
	}

	// 添加一个节点到双向链表最后
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

	// 修改节点
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

		} else { // 没有你修改这个节点

			System.out.println("没有找到这个节点");
		}

	}

	// 删除节点
	public void del(int no) {

		if (head.next == null) {

			System.out.println("链表为空，删除不了");
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
		// 找到
		if (flag) {
//				temp.next=temp.next.next;
			temp.pre.next = temp.next;

			if (temp.next != null) {

				temp.next.pre = temp.pre;
			}

		} else {
			System.out.println("删除的节点不存在");
		}
	}
}

class HeroNode2 {

	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next; // 指向下一个节点
	public HeroNode2 pre; // 指向上一个节点

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
