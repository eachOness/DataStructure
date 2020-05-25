package com.yfan.huffmancode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
	public static void main(String[] args) {
		/*
		 * String str = "i like like like java do you like a java"; byte[] contentBytes
		 * = str.getBytes(); System.out.println(contentBytes.length);
		 */
//		List<Node> nodes = getNodes(contentBytes);
//		System.out.println(nodes);
//		Node root = createHuffmanTree(nodes);
//		// 遍历
//		preOrder(root);
//
//		getCode(root, "", sb);
//		System.out.println("生成的霍夫曼表" + huffmanCode);
//		
//		byte[] zip = zip(contentBytes, huffmanCode);
//		System.out.println("huffmanCodeBytes="+Arrays.toString(zip));
		/*
		 * byte[] huffmanZip = huffmanZip(contentBytes); System.out.println("压缩后的" +
		 * Arrays.toString(huffmanZip));
		 * 
		 * byte[] decode = decode(huffmanCode, huffmanZip); System.out.println("解码后为：" +
		 * new String(decode));
		 * 
		 * 
		 */
		
		String srcFile="C:\\aa.txt";
		String destFile="C:\\zipaa.zip";
		zipFile(srcFile, destFile);
		System.out.println("压缩成功");
		
		

	}

	static Map<Byte, String> huffmanCode = new HashMap<>();
	// 储存某个节点的路径
	static StringBuilder sb = new StringBuilder();

	/**
	 * 将传入的霍夫曼树的所有叶子节点得到 并存放到 {@link HuffmanCode}
	 * 
	 * @param node 传入的节点
	 * @param code 路径 左子节点 0 右 子节点1
	 * @param sb
	 */
	private static void getCode(Node node, String code, StringBuilder sb) {
		StringBuilder stringBuilder = new StringBuilder(sb);
		stringBuilder.append(code);
		if (node != null) {
			if (node.date == null) { // 非叶子结点
				getCode(node.left, "0", stringBuilder);
				getCode(node.right, "1", stringBuilder);
			} else {
				huffmanCode.put(node.date, stringBuilder.toString());
			}
		}

	}

	/**
	 * 将一个byte转换成二进制字符串
	 * 
	 * @param flag
	 * @param by
	 * @return
	 */
	public static String byteToBitString(boolean flag, byte by) {
		int temp = by;
		if (flag) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}

	public static byte[] huffmanZip(byte[] byt) {
		List<Node> nodes = getNodes(byt);
		Node root = createHuffmanTree(nodes);
		getCode(root, "", sb);
		byte[] zip = zip(byt, huffmanCode);

		return zip;
	}

	/**
	 * 
	 * @param huffmanCodes 赫夫曼编码map
	 * @param huffmanBytes 赫夫曼编码得到的字节数组
	 * @return 原来字符串对应的字节数组
	 */
	private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < huffmanBytes.length; i++) {

			byte b = huffmanBytes[i];
			boolean flag = (i == huffmanBytes.length - 1);

			builder.append(byteToBitString(!flag, b));

		}

		Map<String, Byte> map = new HashMap<>();

		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {

			map.put(entry.getValue(), entry.getKey());
		}

		List<Byte> list = new ArrayList<Byte>();
		for (int i = 0; i < builder.length();) {
			int count = 0;
			Byte b = null;
			boolean flag = true;

			while (flag) {

				String key = builder.substring(i, i + count);

				b = map.get(key);
				if (b == null) {
					count++;
				} else {
					flag = false;
				}
			}
			list.add(b);
			i += count; // 直接移动到count指向的索引
		}
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;

	}

	/**
	 * 
	 * @param bytes      原有的字符串对应的 字节数组
	 * @param huffmanMap 上生成后的 霍夫曼码map
	 * @return 压缩后的字节数据
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanMap) {
		StringBuilder sb = new StringBuilder();
		for (byte by : bytes) {
			// 得到霍夫曼编码字符串 133
			sb.append(huffmanMap.get(by));
		}
		// 将 sb 转换为 byte[]
		// 统计返回的huffmanCodeBytes

		int len = (sb.length() + 7) / 8;

		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;// 记录第几个byte
		for (int i = 0; i < sb.length(); i += 8) {
			String strByte;
			if (i + 8 > sb.length()) {
				strByte = sb.substring(i);
			} else {
				strByte = sb.substring(i, i + 8);
			}

			huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}
		return huffmanCodeBytes;

	}

	@SuppressWarnings("unused")
	private static void preOrder(Node root) {
		if (root == null) {
			System.out.println("赫夫曼树为空");
		} else {
			root.preOrde();
		}

	}

	private static List<Node> getNodes(byte[] bs) {

		List<Node> nodes = new ArrayList<Node>();
		Map<Byte, Integer> counts = new HashMap<>();

		for (byte b : bs) {

			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				// 统计字符出现的次数
				counts.put(b, ++count);
			}

		}

		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {

			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;

	}

	/**
	 * 构建一颗霍夫曼树
	 * 
	 * @param nodes
	 * @return
	 */
	public static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {

			Collections.sort(nodes);

			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);

			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;

			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	/**
	 * 
	 * @param srcFile  目标文件的全路径
	 * @param destFile 压缩文件的全路径
	 */
	public static void zipFile(String srcFile, String destFile) {

		OutputStream os = null;
		ObjectOutputStream oos = null;
		FileInputStream is = null;
		try {
			is = new FileInputStream(srcFile);
			byte[] b = new byte[is.available()];
			is.read(b);
			byte[] huffmanByts = huffmanZip(b);
			os = new FileOutputStream(destFile);
			oos = new ObjectOutputStream(os);
			oos.writeObject(huffmanByts);

			oos.writeObject(huffmanCode);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
//			try {
//				/*
//				 * is.close(); os.close(); oos.close();
//				 */
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}

		}

	}
    /**
     * 解压文件
     * @param zipFile
     * @param destFile
     */
	public static void deZip(String zipFile, String destFile) {

		InputStream is = null;

		ObjectInputStream oos = null;

		OutputStream os = null;

		try {
			is = new FileInputStream(zipFile);
			oos = new ObjectInputStream(is);

			byte[] huffmanbytes = (byte[]) oos.readObject();

			Map<Byte, String> huffmanCode = (Map<Byte, String>) oos.readObject();

			byte[] bytes = decode(huffmanCode, huffmanbytes);

			os = new FileOutputStream(destFile);
			os.write(bytes);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				oos.close();
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Node implements Comparable<Node> {
	Byte date; // 存放的数据 ‘a’ =>97
	int weight; // 权值（出现的次数）
	Node left; // 左子树
	Node right; // 右子树

	public Node(Byte date, int weight) {
		super();
		this.date = date;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [date=" + date + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

	public void preOrde() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrde();

		}
		if (this.right != null) {
			this.right.preOrde();

		}
	}

}