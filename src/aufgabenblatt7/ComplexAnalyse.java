package aufgabenblatt7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sun.text.resources.ko.CollationData_ko;

public class ComplexAnalyse {
	private GraphM graph;

	// Graph random ini
	public void graphRand(int size) {
		GraphM temp = new GraphM(size + 1);
		for (int i = 0; i < size; i++) {
			temp.addNode("" + (char) (i + 97));
		}
		for (int k = 0; k < size * 5; k++) {
			temp.addEdge((int) (Math.random() * size), (int) (Math.random() * size),
					(int) ((Math.random() + 1) * size));
		}
		// Correct random
		for (int a = 0; a < size; a++) {
			temp.setGraph(a);
		}
		graph = temp;
	}

	// Read datei
	public void graphIni(String filename) {
		GraphM temp = new GraphM(100);
		String file = filename;
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		int i = 0;

		try {
			br = new BufferedReader(new FileReader(file));
			try {
				while ((line = br.readLine()) != null) {
					String[] data = line.split(splitBy);
					temp.setTableOfContent(i, data[0]);
					temp.setGraphM(i, data);
					i++;
				}
				temp.setSize(i);
				graph = temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ComplexAnalyse test = new ComplexAnalyse();
		int e = 0;
		int v = 10;
		// Graph Ini with csvfile
		test.graphIni("C:/Users/cao/Desktop/TheHAW/4.Sem/AD/Praktikum/stadtentfernungen_dt.csv");

		// Graph Ini random
		// test.graphRand(v);

		// Dijkstra Algorithms
		long start = System.currentTimeMillis();
		test.graph.dijktraValue();
		long end = System.currentTimeMillis();

		// Number of V and E
		for (int m = 0; m < test.graph.getSize(); m++) {
			e = e + test.graph.outEdges(m).size();
		}

		// Cost in time(ms)
		System.out.println("***************************************");
		System.out.println("Number of Edges: " + e);
		System.out.println("Number of Nodes: " + test.graph.getSize());
		System.out.println("Cost in ms: " + (end - start));

		// All nodes output
		System.out.println("************************ALL NODES OUTPUT WITH DISTANCE TO OTHER NODES********************");
		for (int m = 0; m < test.graph.getSize(); m++) {
			for (int n = 0; n < test.graph.getSize(); n++) {
				if (m == n) {
					System.out.println("***********Shortes way from this city to " + test.graph.getTableOfContent()[0]
							+ " *************");
				}
				System.out.println(test.graph.getTableOfContent()[m] + "-" + test.graph.getTableOfContent()[n] + ":"
						+ test.graph.getGraph()[m][n]);
				if (m == n) {
					System.out.println("**************************************************************");
				}
			}
		}
		System.out.println("************TABLE OF PREV (VORGÄNGER) *****************");
		for (int i = 0; i < test.graph.getSize(); i++) {
			System.out.println("PREV OF" + test.graph.getTableOfContent()[i] + ":"
					+ test.graph.getTableOfContent()[test.graph.getDijktra()[i]]);
		}
		System.out.println("*********************TABLE OF CONTENT (ALL NODES LISTED) ********************************");
		String[] text = test.graph.getTableOfContent();
		for (int i = 0; i < test.graph.getSize(); i++) {
			System.out.println(i + ":" + text[i]);
		}

		System.out.println("***********************SHORTEST WAY FROM ANY NODE TO AACHEN ****************************");
		for (int i = 0; i < test.graph.getSize(); i++) {
			System.out.println("SHORTEST WAY FROM " + test.graph.tableOfContent()[i] + "TO AACHEN IS: "
					+ test.graph.way(test.graph.tableOfContent()[i])+ ":" + test.graph.getGraph()[i][i]+"km");
		}
	}
}
