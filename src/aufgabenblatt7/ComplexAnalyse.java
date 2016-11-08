package aufgabenblatt7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sun.text.resources.ko.CollationData_ko;

public class ComplexAnalyse {
	private GraphM graph;

	
	// Graph random ini
	public void graphRand(int length, int size) {
		GraphM temp = new GraphM(length);
		for (int i = 0; i < size; i++) {
			temp.addNode("" + (char) (Math.random() * 256));
		}
		for (int k = 0; k < length; k++) {
			temp.addEdge((int) (Math.random() * size), (int) (Math.random() * size), (int) (Math.random() * length));
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
		// Graph Ini with csvfile
		 test.graphIni("C:/Users/cao/Desktop/TheHAW/4.Sem/AD/Praktikum/stadtentfernungen_dt.csv");
		
		// Graph Ini random
		//test.graphRand(1000, 300);
		//Dijkstra Algorithms
		test.graph.dijktraValue();
		for (int m = 0; m < test.graph.getSize(); m++) {
			for (int n = 0; n < test.graph.getSize(); n++) {
				if (m == n) {
					System.out.println("***********Shortes way from this city to Aachen *************");
				}
				System.out.println(test.graph.getTableOfContent()[m] + "-" + test.graph.getTableOfContent()[n] + ":"
						+ test.graph.getGraph()[m][n]);
				if (m == n) {
					System.out.println("**************************************************************");
				}
			}
		}
		// table of content
		String[] text = test.graph.getTableOfContent();
		for (int i = 0; i < test.graph.getSize(); i++) {
			System.out.println(i + ":" + text[i]);
		}

	}
}
