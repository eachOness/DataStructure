package com.yfan.sparsearray;
/**
 * ������
 * @author 3288609049
 *
 */
public class SingleLinkedList {

	public static void main(String[] args) {
		HeroNode heroNode = new HeroNode(1, "��Ʒ�", "������");
		HeroNode heroNode2 = new HeroNode(2, "������", "���컢");
		HeroNode heroNode3 = new HeroNode(3, "����", "���컢");
		HeroNode heroNode4 = new HeroNode(4, "������", "������");
		SingleList list = new SingleList();
//		list.add(heroNode);
//		list.add(heroNode2);
//		list.add(heroNode3);
//		list.add(heroNode4);
		HeroNode heroNode5 = new HeroNode(3, "����PLUS", "���컢PLUS");
		list.addByOrder(heroNode3);
		list.addByOrder(heroNode2);
		list.addByOrder(heroNode);
		list.addByOrder(heroNode4);
		
		list.showLinkedList();
		
		list.update(heroNode5);
		System.out.println("�޸Ĺ����");
		list.showLinkedList();

	}

}

class SingleList {
	// �ȳ�ʼ��һ���ڵ� ͷ�ڵ㲻Ҫ�� ��������洢������
	private HeroNode head = new HeroNode(0, "", "");

	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// ������ڵ�ֻ���µĽڵ�
		temp.next = heroNode;

	}

	public void showLinkedList() {

		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {

				break;
			}

			System.out.println(temp);
			// ���ڵ�������
			temp = temp.next;

		}
	}
	
	public void addByOrder(HeroNode heroNode) {
		//��Ϊ�ǵ����������ҵ�temp��λ�ڼ���λ�õ�ǰһ���ڵ�
		HeroNode temp=head;
		boolean flag=false;
		
		while(true) {
			if(temp.next==null) {   //�Ѿ������һ���� 
				
				break;
			}
			if(temp.next.no > heroNode.no) {//λ���ҵ���
				
				break;
			}else if(temp.next.no==heroNode.no) {  //��ӵĽڵ�һ����
				
				flag=true;
				break;
			}
			
			temp=temp.next; //��������
			
		}
		if(flag) {
			
			System.out.println("����ı���Ѿ�����"+heroNode.no);
		}else {
			 //���뵽����ĺ���
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
			
		}else {  //û�����޸�����ڵ�
			
			System.out.println("û���ҵ�����ڵ�");
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
		  //�ҵ�
		if(flag) {
			
			temp.next=temp.next.next;
			
		}else {
			
			System.out.println("ɾ���Ľڵ㲻����");
		}
		
		
		
	}
	
	//��ת����
	
	public static void  reverseList(HeroNode head) {
		
		  if(head.next==null || head.next.next==null) {
			  
			  return;
		  }
		  
		  //����һ���������� �������Ǳ���ԭ��������
		  
		  HeroNode cur=head.next;
		  HeroNode next=null; //ָ�򵱵㡾cur������һ���ڵ�
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
