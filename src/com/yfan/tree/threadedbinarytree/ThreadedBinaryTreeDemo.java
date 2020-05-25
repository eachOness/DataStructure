package com.yfan.tree.threadedbinarytree;

/**
 * 线索化二叉树
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
		 * 线索化遍历二叉树 中序遍历
		 */
		public void threadedTreeList() {

			HeroNode node = root;
			while (node != null) {

				while (node.getLeftType() == 0) {
					  node = node.getLeft();

				}
				//打印当前 的节点 
				System.out.println(node);
				  while(node.getRightType() == 1) {
					  node=node.getRight();
					  System.out.println(node);
				  }
				  //替换这个遍历的节点
				  node=node.getRight();
			}

		}

		/**
		 * 线索化的方法 中序遍历
		 * 
		 * @param node
		 */
		public void threadNodes(HeroNode node) {

			if (node == null) {
				return;
			}

			// 先线索化左子树
			threadNodes(node.getLeft());
			// 线索化当前的节点
			if (node.getLeft() == null) {
				// 指向前节点
				node.setLeft(pre);
				node.setLeftType(1);
			}
			// 处理后继节点
			if (pre != null && pre.getRight() == null) {
				pre.setRight(node);
				pre.setRightType(1);
			}

			pre = node;
			// 先线索化右子树

			threadNodes(node.getRight());

		}

		// 前序遍历
		public void preOrder() {

			if (this.root != null) {

				this.root.postOrder();
			} else {

				System.out.println("二叉树为空不能遍历");
			}
		}

		// 中序遍历
		public void infixOrder() {

			if (this.root != null) {

				this.root.infixOrder();
			} else {

				System.out.println("二叉树为空不能遍历");
			}
		}

		// 后序遍历
		public void postOrder() {

			if (this.root != null) {

				this.root.postOrder();
			} else {

				System.out.println("二叉树为空不能遍历");
			}
		}

		/**
		 * 前序查找
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
		 * 中序查找
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
		 * 后序查找
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

				System.out.println("你的二叉树 是空树");
			}

		}

	}
}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	// 如果leftType ==0 说明指向的是左子树 ==1 的话说明指的是前驱节点
	// 如果leftType ==0 说明指向的是左子树 ==1 的话说明指的是后继节点

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
	 * 前序遍历的方法
	 */
	public void preOrder() {
		// 先输出父节点
		System.out.println(this);
		// 递归向左树遍历
		if (this.left != null) {

			this.left.preOrder();
		}
		// 递归向左树遍历
		if (this.right != null) {

			this.right.preOrder();
		}

	}

	/**
	 * 中序遍历的方法
	 */
	public void infixOrder() {

		// 递归向左树遍历
		if (this.left != null) {

			this.left.infixOrder();
		}
		System.out.println(this);
		// 递归向左树遍历
		if (this.right != null) {

			this.right.infixOrder();
		}

	}

	/**
	 * 后序遍历的方法
	 */
	public void postOrder() {

		// 递归向左树遍历
		if (this.left != null) {

			this.left.postOrder();
		}

		// 递归向右树遍历
		if (this.right != null) {

			this.right.postOrder();
		}
		System.out.println(this);
	}

	/**
	 * 前序查找
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
		// 向左递归找到了
		if (res != null) {
			return res;
		}
		if (this.right != null) {
			res = this.right.preOrderSearch(no);
		}
		return res;
	}

	/**
	 * 中序查找
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
	 * 后序查找
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
	  * 删除节点
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