package com.yfan.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 图
 * 
 * @author 3288609049
 *
 */
public class Grapg {
	private int[][] edges; // 存储表对应的邻接矩阵
	private List<String> vertextList; // 存储顶点集合

	private int numOfEdges; // 表示边的数目

	private boolean[] isvIsited;

	public static void main(String[] args) {

		int n = 5;
		String vertexes[] = { "A", "B", "C", "D", "E" };
		Grapg grapg = new Grapg(n);
		for (String vertex : vertexes) {
			grapg.insertVertex(vertex);

		}
		grapg.insertEdge(0, 1, 1);
		grapg.insertEdge(0, 2, 1);
		grapg.insertEdge(1, 2, 1);
		grapg.insertEdge(1, 3, 1);
		grapg.insertEdge(1, 4, 1);
		grapg.bfs();
//		grapg.show();
	}

	public Grapg(int n) {
		edges = new int[n][n];
		vertextList = new ArrayList<>(n);
		numOfEdges = 0;
		isvIsited = new boolean[n];
	}

	// 插入结点
	public void insertVertex(String vertex) {
		vertextList.add(vertex);
	}

	/**
	 * 添加边
	 * 
	 * @param v1
	 * @param v2
	 * @param weight
	 */
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;

	}

	// 得到顶点的个数
	public int getvertextListSize() {
		return vertextList.size();
	}

	// 得到边的数目
	public int getNumOfEdges() {
		return numOfEdges;
	}

	// 得到结点对应的下标
	public String getValueByIndex(int n) {
		return vertextList.get(n);

	}

	/**
	 * 得到第一个临界点下标
	 * 
	 * @param index
	 * @return
	 */
	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertextList.size(); j++) {
			if (edges[index][j] > 0) {
				return j;

			}

		}
		return -1;

	}

	/**
	 * 得到前一个结点的临结点下标
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertextList.size(); j++) {
			if (edges[v1][j] > 0) {
				return j;

			}

		}
		return -1;

	}

	/**
	 * 深度优先遍历
	 * 
	 * @param isvisited
	 * @param i
	 */
	public void dfs(boolean[] isvisited, int i) {
		System.out.println(getValueByIndex(i) + "->");
		isvisited[i] = true;

		int w = getFirstNeighbor(i);
		while (w != -1) { // 证明找到了
			if (!isvisited[w]) {
				dfs(isvisited, w);
			}
			w = getNextNeighbor(w, i);
		}
	}

	/**
   * 广度优先遍历
   * @param isvisited
   * @param i
   */
	public void bfs(boolean[] isvisited, int i) {
		int u;
		int w;
		LinkedList queue=new LinkedList();
		System.out.println(getValueByIndex(i)+"->");
		isvisited[i]=true;
		queue.addLast(i);
		while(!queue.isEmpty()) {
			u=(Integer)queue.removeFirst();
			w=getFirstNeighbor(u);
			while(w!=-1) {
				if(!isvisited[w]) {
					System.out.println(getValueByIndex(w)+"->");
					isvisited[w]=true;
					queue.addLast(w);
				}
				w=getNextNeighbor(u, w);
			}
		}

	}
	
	public void bfs() {
		for (int i = 0; i < getvertextListSize(); i++) {
			if(!isvIsited[i]) {
				bfs(isvIsited, i);
			}
		}
	}

	/**
	 * 返回 v1 v2 对应的权值
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	// 显示图对应的矩阵
	public void show() {
		for (int[] link : edges) {
			System.out.println(Arrays.toString(link));

		}
	}
}
