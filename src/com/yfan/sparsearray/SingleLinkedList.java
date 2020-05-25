package com.yfan.sparsearray;
/**
 * 单链表
 * @author 3288609049
 *
 */
public class SingleLinkedList {

	public static void main(String[] args) {
		HeroNode heroNode = new HeroNode(1, "大黄蜂", "汽车人");
		HeroNode heroNode2 = new HeroNode(2, "威震天", "霸天虎");
		HeroNode heroNode3 = new HeroNode(3, "禁闭", "霸天虎");
		HeroNode heroNode4 = new HeroNode(4, "擎天柱", "汽车人");
		SingleList list = new SingleList();
//		list.add(heroNode);
//		list.add(heroNode2);
//		list.add(heroNode3);
//		list.add(heroNode4);
		HeroNode heroNode5 = new HeroNode(3, "禁闭PLUS", "霸天虎PLUS");
		list.addByOrder(heroNode3);
		list.addByOrder(heroNode2);
		list.addByOrder(heroNode);
		list.addByOrder(heroNode4);
		
		list.showLinkedList();
		
		list.update(heroNode5);
		System.out.println("修改过后的");
		list.showLinkedList();

	}

}

class SingleList {
	// 先初始化一个节点 头节点不要动 不妨具体存储的数据
	private HeroNode head = new HeroNode(0, "", "");

	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// 将这个节点只想新的节点
		temp.next = heroNode;

	}

	public void showLinkedList() {

		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {

				break;
			}

			System.out.println(temp);
			// 将节点往后移
			temp = temp.next;

		}
	}
	
	public void addByOrder(HeroNode heroNode) {
		//因为是单链表我们找的temp是位于加入位置的前一个节点
		HeroNode temp=head;
		boolean flag=false;
		
		while(true) {
			if(temp.next==null) {   //已经是最后一个了 
				
				break;
			}
			if(temp.next.no > heroNode.no) {//位置找到了
				
				break;
			}else if(temp.next.no==heroNode.no) {  //添加的节点一存在
				
				flag=true;
				break;
			}
			
			temp=temp.next; //遍历链表
			
		}
		if(flag) {
			
			System.out.println("插入的编号已经存在"+heroNode.no);
		}else {
			 //插入到链表的后面
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
		
		
		
	}
	
	public void update(HeroNode newheroNode) {
		HeroNode temp=head.next;
		boolean flag=false;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.no==newheroNode.no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.nickName=newheroNode.nickName;
			temp.name=newheroNode.name;
			
		}else {  //没有你修改这个节点
			
			System.out.println("没有找到这个节点");
		}
		
	}
	
	public void del(int no) {
		HeroNode temp=head;
		boolean flag=false;
		
		while(true) {
			if(temp.next==null) {
				break;
			}
			if(temp.next.no==no) {
				
				flag=true;
				break;
			}
			temp=temp.next;
		}
		  //找到
		if(flag) {
			
			temp.next=temp.next.next;
			
		}else {
			
			System.out.println("删除的节点不存在");
		}
		
		
		
	}
	
	//反转链表
	
	public static void  reverseList(HeroNode head) {
		
		  if(head.next==null || head.next.next==null) {
			  
			  return;
		  }
		  
		  //定义一个辅助变量 帮助我们遍历原来的链表
		  
		  HeroNode cur=head.next;
		  HeroNode next=null; //指向当点【cur】的下一个节点
		  HeroNode reseverHead = new HeroNode(0,"","");
		  
		  while(cur!=null) {
			  
			  next=cur.next;
			  cur.next=reseverHead.next;
			  reseverHead.next=cur;
			  cur=next;
		  }
		  head.next=reseverHead.next;
		
	}

}

class HeroNode {

	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + " ]";
	}

}
