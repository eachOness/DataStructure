package com.yfan.binarytree;

/**
 * 二叉树
 * 
 * @author 3288609049
 *
 */
public class BinaryTree {
	public static void main(String[] args) {
		BinarySortTree binarySortTree = new BinarySortTree();
		int arr[] = {  4, 7, 5, 9, 1, 10, 12 };
		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add(new Node(arr[i]));
		}
		
		binarySortTree.delNode(4);
		binarySortTree.midPre();

	}

}

class BinarySortTree {
	Node root;

	public void add(Node node) {
		if (root == null) {
			this.root = node;

		} else {
			root.add(node);
		}

	}

	public void midPre() {
		if (root == null) {
			System.out.println("二叉排序树为空");
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
			// 找到要删除的父节点
			Node parent = searchParent(val);

			// 如果要删除的是叶子结点
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

			} else { // 删除止只有一颗子树的结点
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
	 * 查找要删除的结点
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
	 * 查找要删除的父节点
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
				return null; // 么有找到父节点
			}

		}

	}

}
