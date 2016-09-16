package aufgabenblatt1;

public class Aufwandsanalyse {
	// list ini
	private void listini(Liste list, int size) throws UnvalidActionException {
		for (int i = 0; i < size; i++) {
			list.insert(i, (int) Math.random() * 100);
		}
	}

	private void print(String test, int countArray, int countLinkedlist, int countArrayLink) {
		System.out.format("Testfall:%s \n Array: %d \n Linkedlist: %d\n ArrayLink %d\n", test, countArray,
				countLinkedlist, countArrayLink);
	}

	public static void main(String[] args) throws UnvalidActionException {
		Aufwandsanalyse test = new Aufwandsanalyse();
		int number = 70;
		// Create list
		Liste array = new Array<Integer>(10, 100);
		Liste linkedlist = new Linkedlist<Integer>();
		Liste arraylink = new ArrayLink<Integer>(10, 100);
		// List ini
		test.listini(array, number);
		test.listini(linkedlist, number);
		test.listini(arraylink, number);

		
		// Insert am Anfang
		array.insert(0, 100);
		linkedlist.insert(0, 100);
		arraylink.insert(0, 100);
		test.print("Insert at the beginning", array.getCounter().getCounter(), linkedlist.getCounter().getCounter(),
				arraylink.getCounter().getCounter());
		// Insert am Ende
		array.insert(number, 100);
		linkedlist.insert(number, 100);
		arraylink.insert(number, 100);
		test.print("Insert at the end", array.getCounter().getCounter(), linkedlist.getCounter().getCounter(),
				arraylink.getCounter().getCounter());
		// insert an beliebige Stelle
		array.insert((int)Math.random()*number, 100);
		linkedlist.insert((int)Math.random()*number, 100);
		arraylink.insert((int)Math.random()*number, 100);
		test.print("Insert at the end", array.getCounter().getCounter(), linkedlist.getCounter().getCounter(),
				arraylink.getCounter().getCounter());

		// Suchen
		// Der Element befindet sich am Anfang
		// Der Element befindet sich am Ende
		// Der Element befindet sich in der Mitte
		// Der Element ist nicht in der Liste

		/*
		 * Array array = new Array<Integer>(10, 2); Linkedlist linklist = new
		 * Linkedlist<Integer>(); ArrayLink arraylink = new
		 * ArrayLink<Integer>(10, 2);
		 * 
		 * array.insert(0, 0); array.insert(0, 1); array.insert(0, 2);
		 * 
		 * linklist.insert(0, 0); linklist.insert(0, 1); linklist.insert(0, 2);
		 * 
		 * arraylink.insert(0, 0); arraylink.insert(0, 1); arraylink.insert(0,
		 * 2);
		 * 
		 * System.out.println(array.getCounter().getCounter());
		 * System.out.println(linklist.getCounter().getCounter());
		 * System.out.println(arraylink.getCounter().getCounter());
		 */
	}
}
