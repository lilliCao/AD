package aufgabenblatt1;

public class Aufwandsanalyse {
	private void changeSizeOfList() {

	}

	public static void main(String[] args) throws UnvalidActionException {
		Array array = new Array<Integer>(10, 2);
		Linkedlist linklist = new Linkedlist<Integer>();
		ArrayLink arraylink = new ArrayLink<Integer>(10, 2);

		array.insert(0, 0);
		array.insert(0, 1);
		array.insert(0, 2);
		
		linklist.insert(0, 0);
		linklist.insert(0, 1);
		linklist.insert(0, 2);
		
		arraylink.insert(0, 0);
		arraylink.insert(0, 1);
		arraylink.insert(0, 2);
		
		
		System.out.println(array.getCounter().getCounter());
		System.out.println(linklist.getCounter().getCounter());
		System.out.println(arraylink.getCounter().getCounter());
	}
}
