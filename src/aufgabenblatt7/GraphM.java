package aufgabenblatt7;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This class describes a graph in a nxn matrix
 * 
 * @author cao
 *
 */
public class GraphM implements I_Graph {
	private int[][] graph;
	private int length;
	private int size;
	private String[] tableOfContent;
	private int[] dijktra;

	// constructor
	public GraphM(int length) {
		this.length = length;
		this.graph = new int[length][length];
		this.size = 0;
		this.tableOfContent = new String[length];
		this.dijktra = new int[length];
	}

	// getter and setter
	public int[][] getGraph() {
		return this.graph;
	}

	public int getSize() {
		return this.size;
	}

	public int[] getDijktra() {
		return this.dijktra;
	}

	public String[] getTableOfContent() {
		return this.tableOfContent;
	}

	public void setTableOfContent(int i, String city) {
		this.tableOfContent[i] = city;

	}

	// Hilfmethod for complexity analyse
	public void setGraph(int n) {
		graph[n][n] = 0;
	}

	// set row i of the matrix with the data from String[] data
	public void setGraphM(int i, String[] data) {
		for (int k = 1; k < data.length; k++) {
			this.graph[i][k - 1] = Integer.parseInt(data[k]);
		}
	}

	public void setSize(int i) {
		this.size = i;
	}

	@Override
	// A new column and a new row will be reserved for the new node.Table of
	// Content will be updated

	public void addNode(String name) {
		this.size++;
		for (int i = 0; i < this.size; i++) {
			graph[i][this.size] = 0;
			graph[this.size][i] = 0;
		}
		tableOfContent[this.size - 1] = name;
	}

	// Node with index n is element nxn in the matrix. All the columns on the
	// left side of this node will be
	// shifted left and all the rows under this node will be shifted up. Table
	// of Content will be updated

	@Override
	public void removeNode(int n) {
		for (int i = n; i < this.size - 1; i++) {
			tableOfContent[i] = tableOfContent[i + 1];
			for (int j = 0; j < this.size - 1; j++) {
				if (j > n) {
					graph[i][j] = graph[i + 1][j + 1];
				}
				if (j < n) {
					graph[j][i] = graph[j][i + 1]; // shift left
					graph[i][j] = graph[i + 1][j];// shift up
				}

			}
		}
		for (int a = 0; a < size; a++) {
			graph[a][size - 1] = 0;
			graph[size - 1][a] = 0;
		}

		this.size--;

	}

	@Override
	public void addEdge(int i, int j, int value) {
		graph[i][j] = value;

	}

	@Override
	public void removeEdge(int i, int j) {
		graph[i][j] = 0;

	}

	@Override
	public int hasEdge(int i, int j) {
		return graph[i][j];
	}

	@Override
	public List<Integer> outEdges(int n) {
		List<Integer> edges = new ArrayList<Integer>();
		for (int j = 0; j < this.size; j++) {
			if (graph[n][j] != 0) {
				edges.add(j);
			}
		}
		return edges;
	}

	@Override
	public List<Integer> inEdges(int n) {
		List<Integer> edges = new ArrayList<Integer>();
		for (int j = 0; j < this.size; j++) {
			if (graph[j][n] != 0) {
				edges.add(j);
			}
		}
		return edges;
	}

	@Override
	// values of the shortest way to each node will be inserted in the main
	// diagonal of the matrix

	public void dijktraValue() {
		// Queue
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		// Ini all nodes with Integer.MAX_VALUE
		for (int i = 0; i < this.size; i++) {
			graph[i][i] = Integer.MAX_VALUE;
		}
		int start = 0;
		graph[start][start] = 0;
		queue.add(graph[start][start]);
		while (!queue.isEmpty()) {
			// choose the node with the shortest way
			int n = queue.poll();
			for (int k = 0; k < this.size; k++) {
				// all edges from start node
				if (graph[n][k] != 0) {
					if (graph[k][k] > graph[n][n] + graph[n][k]) {
						this.dijktra[k] = n;
						graph[k][k] = graph[n][n] + graph[n][k];
						queue.add(k);
					}
				}
			}
		}
	}

	@Override
	public String[] tableOfContent() {
		return tableOfContent;
	}

	public String way(String to) {
		// Exception a und b is nicht in der Graph
		//
		String way="";
		int a = 0;
		for (int i = 0; i < this.tableOfContent.length; i++) {
			if (to.equals(this.tableOfContent[i])) {
				a = i;
				break;
			}
		}

		List<Integer> list = new ArrayList();
		int tmp = a;
		list.add(tmp);
		int n = 0;
		while (tmp != 0) {
			tmp = dijktra[tmp];
			list.add(tmp);
			n++;
			if (n == this.tableOfContent.length) {
				break;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			way += this.tableOfContent[list.get(i)] + "-";
		}
		return way;

	}

	public static void main(String[] args) {
		GraphM test = new GraphM(10);
		test.addNode("A");
		test.addNode("B");
		test.addNode("C");
		test.addNode("D");
		test.addNode("E");
		test.addEdge(0, 1, 10);
		test.addEdge(1, 2, 20);
		test.addEdge(1, 3, 30);
		test.addEdge(3, 2, 50);
		test.addEdge(2, 3, 80);
		// test.addEdge(0, 1, 17);
		test.addEdge(2, 4, 45);
		test.addEdge(3, 4, 10);
		// test.removeNode(0);
		test.dijktraValue();
		System.out.println("*************GRAPH INI**************");
		for (int m = 0; m < test.size; m++) {
			for (int n = 0; n < test.size; n++) {
				System.out.println(m + "" + n + ":" + test.graph[m][n]);
			}
		}
		System.out.println("**************TABLE OF CONTENT************");
		for (int i = 0; i < test.size; i++) {
			System.out.println(i + ":" + test.tableOfContent[i]);
		}
		System.out.println("************TABLE OF PREV*****************");
		for (int i = 0; i < test.size; i++) {
			System.out.println(test.tableOfContent[i] + ":" + test.tableOfContent[test.dijktra[i]]);
		}
		System.out.println("**************CHECK EDGES****************");
		// List<Integer> t= test.outEdges(2);
		List<Integer> t = test.inEdges(1);
		for (int a = 0; a < t.size(); a++) {
			System.out.println(t.get(a));
		}
	}
}
