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
//		// ����
//		preOrder(root);
//
//		getCode(root, "", sb);
//		System.out.println("���ɵĻ�������" + huffmanCode);
//		
//		byte[] zip = zip(contentBytes, huffmanCode);
//		System.out.println("huffmanCodeBytes="+Arrays.toString(zip));
		/*
		 * byte[] huffmanZip = huffmanZip(contentBytes); System.out.println("ѹ�����" +
		 * Arrays.toString(huffmanZip));
		 * 
		 * byte[] decode = decode(huffmanCode, huffmanZip); System.out.println("�����Ϊ��" +
		 * new String(decode));
		 * 
		 * 
		 */
		
		String srcFile="C:\\aa.txt";
		String destFile="C:\\zipaa.zip";
		zipFile(srcFile, destFile);
		System.out.println("ѹ���ɹ�");
		
		

	}

	static Map<Byte, String> huffmanCode = new HashMap<>();
	// ����ĳ���ڵ��·��
	static StringBuilder sb = new StringBuilder();

	/**
	 * ������Ļ�������������Ҷ�ӽڵ�õ� ����ŵ� {@link HuffmanCode}
	 * 
	 * @param node ����Ľڵ�
	 * @param code ·�� ���ӽڵ� 0 �� �ӽڵ�1
	 * @param sb
	 */
	private static void getCode(Node node, String code, StringBuilder sb) {
		StringBuilder stringBuilder = new StringBuilder(sb);
		stringBuilder.append(code);
		if (node != null) {
			if (node.date == null) { // ��Ҷ�ӽ��
				getCode(node.left, "0", stringBuilder);
				getCode(node.right, "1", stringBuilder);
			} else {
				huffmanCode.put(node.date, stringBuilder.toString());
			}
		}

	}

	/**
	 * ��һ��byteת���ɶ������ַ���
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
	 * @param huffmanCodes �շ�������map
	 * @param huffmanBytes �շ�������õ����ֽ�����
	 * @return ԭ���ַ�����Ӧ���ֽ�����
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
			i += count; // ֱ���ƶ���countָ�������
		}
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;

	}

	/**
	 * 
	 * @param bytes      ԭ�е��ַ�����Ӧ�� �ֽ�����
	 * @param huffmanMap �����ɺ�� ��������map
	 * @return ѹ������ֽ�����
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanMap) {
		StringBuilder sb = new StringBuilder();
		for (byte by : bytes) {
			// �õ������������ַ��� 133
			sb.append(huffmanMap.get(by));
		}
		// �� sb ת��Ϊ byte[]
		// ͳ�Ʒ��ص�huffmanCodeBytes

		int len = (sb.length() + 7) / 8;

		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;// ��¼�ڼ���byte
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
			System.out.println("�շ�����Ϊ��");
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
				// ͳ���ַ����ֵĴ���
				counts.put(b, ++count);
			}

		}

		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {

			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;

	}

	/**
	 * ����һ�Ż�������
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
	 * @param srcFile  Ŀ���ļ���ȫ·��
	 * @param destFile ѹ���ļ���ȫ·��
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
     * ��ѹ�ļ�
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
	Byte date; // ��ŵ����� ��a�� =>97
	int weight; // Ȩֵ�����ֵĴ�����
	Node left; // ������
	Node right; // ������

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