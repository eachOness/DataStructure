package com.yfan.avl;

/**
 * avl ��
 * 
 * @author 3288609049
 *
 */
public class AVLTree {
	public static void main(String[] args) {
		/*
		 * int[] arr = { 4, 3, 6, 5, 7, 8 }; int[] arr1 = { 10, 12, 8, 9, 7, 6 };
		 */
		
		int[] arr = { 10,11,7,6,8,9 };
		AvlTree1 avlTree = new AvlTree1();
		for (int i = 0; i < arr.length; i++) {
			avlTree.add(new Node(arr[i]));

		}
		System.out.println("�������");

		avlTree.midPre();

		System.out.println(avlTree.getRoot().height());
		System.out.println(avlTree.getRoot().leftHeight());
		System.out.println(avlTree.getRoot().rightHeight());
	}

}

class AvlTree1 {

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	private Node root;

	public void add(Node node) {
		if (root == null) {
			this.root = node;

		} else {
			root.add(node);
		}

	}

	public void midPre() {
		if (root == null) {
			System.out.println("����������Ϊ��");
		} else {
			root.midList();
		}

	}

	public Node Search(int val) {
		if (root == null) {
			return null;
		} else {
			return root.searchNode(val);
		}

	}

	public Node searchParent(int val) {
		if (root == null) {
			return null;
		} else {
			return root.serachParentNode(val);
		}

	}

	public void delNode(int val) {
		if (root == null) {
			return;
		} else {

			Node targetNode = Search(val);

			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			// �ҵ�Ҫɾ���ĸ��ڵ�
			Node parent = searchParent(val);

			// ���Ҫɾ������Ҷ�ӽ��
			if (targetNode.left == null && targetNode.right == null) {

				if (parent.left != null && parent.left.val == val) {

					parent.left = null;

				}
				if (parent.right != null && parent.right.val == val) {

					parent.right = null;

				}

			} else if (targetNode.left != null && targetNode.right != null) {

				int minVal = delRightTreeMin(targetNode.right);
				targetNode.val = minVal;

			} else { // ɾ��ֹֻ��һ�������Ľ��
				if (targetNode.left != null) {

					if (parent == null) {
						root = targetNode.left;

					} else {

						if (parent.left.val == val) {
							parent.left = targetNode.left;
						} else {
							parent.right = targetNode.left;
						}
					}

				} else {
					if (parent == null) {
						root = targetNode.right;

					} else {
						if (parent.left.val == val) {
							parent.left = targetNode.right;
						} else {
							parent.right = targetNode.right;
						}
					}

				}

			}
		}
	}

	public int delRightTreeMin(Node node) {
		Node temp = node;
		while (node.left != null) {
			temp = node.left;
		}
		delNode(temp.val);
		return temp.val;
	}

}

class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		super();
		this.val = val;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}

	// �����������ĸ߶�
	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	// �����������ĸ߶�
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	// ���ص�ǰ���ĸ߶�
	public int height() {

		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;

	}

	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (this.val > node.val) {

			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}

		} else {

			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}

		}

		if (rightHeight() - leftHeight() > 1) {

			if (right != null && right.leftHeight() > right.rightHeight()) {

				right.rightRotate();
				leftRotate();

			} else {

				leftRotate();
			}
			return ; //!!!!!!!!!!!!!!!!!!!!

		}
		if (leftHeight() - rightHeight() > 1) {

			if (left != null && left.rightHeight() > left.leftHeight()) {

				left.leftRotate();
				rightRotate();

			} else {
				rightRotate();
			}
		

		}
	}

	public void midList() {

		if (this.left != null) {
			this.left.midList();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.midList();
		}

	}

	/**
	 * ����Ҫɾ���Ľ��
	 * 
	 * @return
	 */
	public Node searchNode(int val) {

		if (this.val == val) {
			return this;
		} else if (this.val > val) {
			if (this.left == null) {
				return null;
			}

			return this.left.searchNode(val);
		} else {
			if (this.right == null) {
				return null;
			}

			return this.right.searchNode(val);
		}

	}

	/**
	 * ����Ҫɾ���ĸ��ڵ�
	 * 
	 * @param val
	 * @return
	 */
	public Node serachParentNode(int val) {
		if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
			return this;
		} else {

			if (val < this.val && this.left != null) {
				return this.left.serachParentNode(val);
			} else if (val >= this.val && this.right != null) {

				return this.right.serachParentNode(val);
			} else {
				return null; // ô���ҵ����ڵ�
			}

		}

	}

	/**
	 * ����ת
	 */
	public void leftRotate() {

		Node newNode = new Node(val);

		newNode.left = left;
		newNode.right = right.left;
		val = right.val;
		right = right.right;
		left = newNode;

	}

	/**
	 * ����ת
	 */
	public void rightRotate() {
		Node newNode = new Node(val);
		newNode.right = right;
		newNode.left = left.right;
		val = left.val;
		left = left.left;
		right = newNode;

	}

}
