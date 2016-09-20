package aufgabenblatt1;

import java.util.Scanner;

public class Aufwandsanalyse {
	// list ini
	private void listini(Liste list, int numberOfElement) throws UnvalidActionException {
		for (int i = 0; i < numberOfElement; i++) {
			list.insert(i, i);
		}
	}

	public static void main(String[] args) throws UnvalidActionException {
		Aufwandsanalyse test = new Aufwandsanalyse();
		int size = 1000;

		// Create list
		Liste array = new Array<Integer>(100, size);
		Liste linkedlist = new Linkedlist<Integer>();
		Liste arraylink = new ArrayLink<Integer>(100, size);
		Liste tlist;

		// Testlist
		tlist = array;

		// List ini
		System.out.print("Number Inserted Element:");
		Scanner scanner = new Scanner(System.in);
		int numberOfElement = scanner.nextInt();
		test.listini(tlist, numberOfElement);
		int count = tlist.getCounter().getCounter();

		// Test Methode
		tlist.find(numberOfElement / 2);
		System.out.println(tlist.getCounter().getCounter() - count);
	}

}
