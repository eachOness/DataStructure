package com.yfan.tree.threadedbinarytree;

/**
 * ������������
 * 
 * @author 3288609049
 *
 */
public class ThreadedBinaryTreeDemo {
	public static void main(String[] args) {

	}

	class ThreadBinarysTree {
		private HeroNode root;
		private HeroNode pre;

		public void setHeroNode(HeroNode root) {
			this.root = root;
		}

		/**
		 * ���������������� �������
		 */
		public void threadedTreeList() {

			HeroNode node = root;
			while (node != null) {

				while (node.getLeftType() == 0) {
					  node = node.getLeft();

				}
				//��ӡ��ǰ �Ľڵ� 
				System.out.println(node);
				  while(node.getRightType() == 1) {
					  node=node.getRight();
					  System.out.println(node);
				  }
				  //�滻��������Ľڵ�
				  node=node.getRight();
			}

		}

		/**
		 * �������ķ��� �������
		 * 
		 * @param node
		 */
		public void threadNodes(HeroNode node) {

			if (node == null) {
				return;
			}

			// ��������������
			threadNodes(node.getLeft());
			// ��������ǰ�Ľڵ�
			if (node.getLeft() == null) {
				// ָ��ǰ�ڵ�
				node.setLeft(pre);
				node.setLeftType(1);
			}
			// �����̽ڵ�
			if (pre != null && pre.getRight() == null) {
				pre.setRight(node);
				pre.setRightType(1);
			}

			pre = node;
			// ��������������

			threadNodes(node.getRight());

		}

		// ǰ�����
		public void preOrder() {

			if (this.root != null) {

				this.root.postOrder();
			} else {

				System.out.println("������Ϊ�ղ��ܱ���");
			}
		}

		// �������
		public void infixOrder() {

			if (this.root != null) {

				this.root.infixOrder();
			} else {

				System.out.println("������Ϊ�ղ��ܱ���");
			}
		}

		// �������
		public void postOrder() {

			if (this.root != null) {

				this.root.postOrder();
			} else {

				System.out.println("������Ϊ�ղ��ܱ���");
			}
		}

		/**
		 * ǰ�����
		 * 
		 * @param no
		 * @return
		 */
		public HeroNode preOrderSearch(int no) {
			if (root != null) {
				return root.preOrderSearch(no);
			} else {
				return null;
			}

		}

		/**
		 * �������
		 * 
		 * @param no
		 * @return
		 */
		public HeroNode infixOrderSearch(int no) {
			if (root != null) {
				return root.infixOrderSearch(no);
			} else {
				return null;
			}

		}

		/**
		 * �������
		 * 
		 * @param no
		 * @return
		 */
		public HeroNode postOrderSearch(int no) {
			if (root != null) {
				return root.postOrderSearch(no);
			} else {
				return null;
			}

		}

		public void delNode(int no) {

			if (root != null) {

				if (root.getNo() == no) {
					root = null;
				} else {
					root.delNode(no);

				}

			} else {

				System.out.println("��Ķ����� �ǿ���");
			}

		}

	}
}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	// ���leftType ==0 ˵��ָ����������� ==1 �Ļ�˵��ָ����ǰ���ڵ�
	// ���leftType ==0 ˵��ָ����������� ==1 �Ļ�˵��ָ���Ǻ�̽ڵ�

	private int leftType;

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	private int rightType;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	/**
	 * ǰ������ķ���
	 */
	public void preOrder() {
		// ��������ڵ�
		System.out.println(this);
		// �ݹ�����������
		if (this.left != null) {

			this.left.preOrder();
		}
		// �ݹ�����������
		if (this.right != null) {

			this.right.preOrder();
		}

	}

	/**
	 * ��������ķ���
	 */
	public void infixOrder() {

		// �ݹ�����������
		if (this.left != null) {

			this.left.infixOrder();
		}
		System.out.println(this);
		// �ݹ�����������
		if (this.right != null) {

			this.right.infixOrder();
		}

	}

	/**
	 * ��������ķ���
	 */
	public void postOrder() {

		// �ݹ�����������
		if (this.left != null) {

			this.left.postOrder();
		}

		// �ݹ�����������
		if (this.right != null) {

			this.right.postOrder();
		}
		System.out.println(this);
	}

	/**
	 * ǰ�����
	 * 
	 * @param no
	 * @return
	 */
	public HeroNode preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		HeroNode res = null;
		if (this.left != null) {
			res = this.left.preOrderSearch(no);
		}
		// ����ݹ��ҵ���
		if (res != null) {
			return res;
		}
		if (this.right != null) {
			res = this.right.preOrderSearch(no);
		}
		return res;
	}

	/**
	 * �������
	 * 
	 * @param no
	 * @return
	 */
	public HeroNode infixOrderSearch(int no) {

		HeroNode res = null;
		if (this.left != null) {
			res = this.left.infixOrderSearch(no);
		}
		if (res != null) {
			return res;
		}
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			res = this.right.infixOrderSearch(no);
		}
		return res;
	}

	/**
	 * �������
	 * 
	 * @param no
	 * @return
	 */
	public HeroNode postOrderSearch(int no) {

		HeroNode res = null;
		if (this.left != null) {
			res = this.left.postOrderSearch(no);
		}
		if (res != null) {
			return res;
		}
		if (this.right != null) {
			res = this.right.postOrderSearch(no);
		}
		if (this.no == no) {
			return this;
		}
		return res;
	}

	/**
	  * ɾ���ڵ�
	  */
	public  void  delNode(int no) {
		if(this.left!=null&& this.left.no==no) {
			this.left=null;
			return ;
		}
		if(this.right!=null&& this.right.no==no) {
			this.right=null;
			return ;
		}
		
		if(this.left!=null) {
			this.left.delNode(no);
		}
		if(this.right!=null) {
			this.right.delNode(no);
		}
	}
	
}