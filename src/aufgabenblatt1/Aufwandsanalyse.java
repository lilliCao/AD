package aufgabenblatt1;

import java.util.Scanner;

public class Aufwandsanalyse {
	// list ini
	private void listini(Liste list, int numberOfElement) throws UnvalidActionException {
		for (int i = 0; i < numberOfElement; i++) {
			list.insert(i, (int) Math.random() * 100);
		}
	}

	private void print(String test, int countArray, int countLinkedlist, int countArrayLink) {
		System.out.format("Testfall:%s \n Array: %d \n Linkedlist: %d\n ArrayLink %d\n", test, countArray,
				countLinkedlist, countArrayLink);
	}

	public static void main(String[] args) throws UnvalidActionException {
		Aufwandsanalyse test = new Aufwandsanalyse();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Size of list:");
		int size = scanner.nextInt();
		System.out.print("Number Inserted Element:");
		int numberOfElement = scanner.nextInt();
		scanner.close();

		// Create list
		Liste array = new Array<Integer>(10, size);
		Liste linkedlist = new Linkedlist<Integer>();
		Liste arraylink = new ArrayLink<Integer>(10, size);

		// List ini
		test.listini(array, numberOfElement);
		test.listini(linkedlist, numberOfElement);
		test.listini(arraylink, numberOfElement);

		// old count
		int countA = array.getCounter().getCounter();
		int countL = linkedlist.getCounter().getCounter();
		int countAL = arraylink.getCounter().getCounter();

		// Insert am Anfang
		// Insert am Ende
		// Insert an einer beliebige Position

		int a = 7;
		// Delete at the beginning
		array.delete(a);
		linkedlist.delete(a);
		arraylink.delete(a);

		int newCountA = array.getCounter().getCounter();
		int newCountL = linkedlist.getCounter().getCounter();
		int newCountAL = arraylink.getCounter().getCounter();

		test.print("Delete at the beginning", newCountA - countA, newCountL - countL, newCountAL - countAL);

		// Suchen
		// Der Element befindet sich am Anfang
		// Der Element befindet sich am Ende
		// Der Element befindet sich in der Mitte
		// Der Element ist nicht in der Liste

	}
}
