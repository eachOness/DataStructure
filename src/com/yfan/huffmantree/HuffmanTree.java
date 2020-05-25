package com.yfan.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * �շ�����
 * 
 * @author 3288609049
 *
 */
public class HuffmanTree {
	public static void main(String[] args) {
		int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}
	
	public static void preOrder(Node root) {
		if(root!=null) {
			root.preList();
		}else {
			System.out.println("������ǿ���");
		}
		
	}

	public static Node createHuffmanTree(int[] arr) {

		List<Node> nodes = new ArrayList<Node>();

		for (int value : arr) {
			nodes.add(new Node(value));

		}
		Collections.sort(nodes);
		System.out.println(nodes);
		while (nodes.size() >1 ) {
			// ȡ��Ȩֵ��С �Ľڵ�

			Node leftNode = nodes.get(0);
			// ȡ��Ȩֵ�ڶ���С�Ľڵ�
			Node rightNode = nodes.get(1);
			// ����һ���µĶ�����
			Node parent = new Node(leftNode.val + rightNode.val);
			parent.left = leftNode;
			parent.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
			System.out.println(nodes);
		}
		return nodes.get(0);
	}

}

/**
 * �����ڵ���
 * 
 * @author 3288609049
 *
 */
class Node implements Comparable<Node> {

	int val;// �ڵ��Ȩֵ
	Node left; // ��ڵ�
	Node right;// �ҽڵ�

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}

	public Node(int val) {
		super();
		this.val = val;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}

	public void preList() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preList();
		}
		if (this.right != null) {
			this.right.preList();
		}

	}

}