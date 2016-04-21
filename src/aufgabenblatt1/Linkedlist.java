package aufgabenblatt1;

import javax.imageio.IIOException;

public class Linkedlist<T> implements Liste<T> {
	private int size;
	private Knoten<T> heap;

	/**
	 * Konstruktor
	 */
	public Linkedlist() {
		this.size = 0;
		this.heap = new Knoten<T>();
	}

	/**
	 * Getter
	 */
	public Knoten<T> getHeap() {
		return heap;
	}

	/**
	 * Setter
	 */
	public void setHeap(Knoten<T> knoten) {
		this.heap = knoten;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (pos < 0 || pos > size || elem == null) {
			throw new UnvalidActionException("Ungültige Position oder ungültiges Element");
		}
		Knoten<T> tmp = this.heap;
		Knoten<T> insertKnoten = new Knoten(elem);
		for (int i = 0; i < pos; i++) {
			tmp = tmp.getNext();
		}
		insertKnoten.setNext(tmp.getNext());
		tmp.setNext(insertKnoten);
		size++;

	}

	@Override
	public void delete(int pos) {
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		Knoten<T> tmp = heap;
		for (int i = 0; i < pos; i++) {
			tmp = tmp.getNext();
		}
		tmp.setNext(tmp.getNext().getNext());
		size--;

	}

	@Override
	public int find(T elem) {
		Knoten<T> tmp = heap;
		for (int i = 0; i < size; i++) {
			tmp = tmp.getNext();
			if (tmp.getContent().equals(elem))
				return i;
		}
		return -1;
	}

	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		Knoten<T> tmp = this.heap.getNext();
		for (int i = 0; i < pos; i++) {
			tmp = tmp.getNext();
		}
		return tmp.getContent();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void concat(Liste otherlist) throws NullPointerException {
		if (otherlist == null) {
			throw new NullPointerException();
		}
		Knoten<T> tmp = heap;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(((Linkedlist<T>) otherlist).heap.getNext());
		size = size + otherlist.size();
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) throws UnvalidActionException {

		Linkedlist<Integer> test = new Linkedlist<Integer>();
		Linkedlist<Integer> test2 = new Linkedlist<Integer>();
		test.insert(0, 0);
		test.insert(1, 1);
		test.insert(2, 6);
		//test.delete(3);
		// test.delete(2);

		// test.delete(1);
	
		test2.concat(test);
		System.out.println(test2.size());
//		System.out.println(test.retrieve(3));

	}
}
