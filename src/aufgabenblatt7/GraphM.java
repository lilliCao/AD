package aufgabenblatt7;

import java.util.ArrayList;
import java.util.List;

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

	// constructor
	public GraphM(int length) {
		this.length = length;
		this.graph = new int[length][length];
		this.size = 0;
		this.tableOfContent = new String[length];
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

	}

	@Override
	public String[] tableOfContent() {
		return tableOfContent;
	}

	public static void main(String[] args) {
		GraphM test = new GraphM(10);
		test.addNode("A");
		test.addNode("B");
		test.addNode("C");
		test.addNode("D");
		test.addEdge(0, 1, 10);
		test.addEdge(1, 2, 20);
		test.addEdge(1, 3, 30);
		test.addEdge(3, 3, 50);
		test.addEdge(2, 3, 80);
		test.addEdge(0, 1, 17);
		//test.removeNode(0);
		System.out.println(test.graph[1][2]);
		for (int i = 0; i < test.size; i++) {
			System.out.println(test.tableOfContent[i]);
		}
		//List<Integer> t= test.outEdges(2);
		List<Integer> t= test.inEdges(3);
		
		for(int a =0; a< t.size(); a++){
		System.out.println(t.get(a));
		}
	}
}
