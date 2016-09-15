package aufgabenblatt1;

import javax.imageio.IIOException;

public class Linkedlist<T> implements Liste<T> {
	private int size;
	private Knoten<T> head;
	private Counter counter;

	/**
	 * Konstruktor
	 */
	public Linkedlist() {
		this.size = 0;
		this.head = new Knoten<T>();
		this.counter = new Counter();
	}

	/**
	 * Getter
	 */
	public Knoten<T> getHead() {
		return head;
	}

	/**
	 * Setter
	 */
	public void setHead(Knoten<T> knoten) {
		this.head = knoten;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (pos >= 0 && pos <= size && elem != null) {
			counter.counterUp(1);
			Knoten<T> tmp = this.head;
			Knoten<T> insertKnoten = new Knoten(elem);
			counter.counterUp(1);
			for (int i = 0; i < pos; i++) {
				counter.counterUp(1);
				tmp = tmp.getNext();
			}
			insertKnoten.setNext(tmp.getNext());
			tmp.setNext(insertKnoten);
			size++;
			counter.counterUp(1);
		} else {
			throw new UnvalidActionException("Ungültige Position oder ungültiges Element");
		}
	}

	@Override
	public void delete(int pos) {
		if (pos >= 0 && pos < size) {
			counter.counterUp(1);
			Knoten<T> tmp = head;
			for (int i = 0; i < pos; i++) {
				counter.counterUp(1);
				tmp = tmp.getNext();
			}
			tmp.setNext(tmp.getNext().getNext());
			size--;
			counter.counterUp(1);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int find(T elem) {
		Knoten<T> tmp = head;
		for (int i = 0; i < size; i++) {
			counter.counterUp(1);
			tmp = tmp.getNext();
			if (tmp.getContent().equals(elem))
				counter.counterUp(1);
			return i;
		}
		return -1;
	}

	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos < size) {
			counter.counterUp(1);
			Knoten<T> tmp = this.head.getNext();
			for (int i = 0; i < pos; i++) {
				counter.counterUp(1);
				tmp = tmp.getNext();
			}
			return tmp.getContent();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void concat(Liste otherlist) throws NullPointerException {
		if (otherlist != null && otherlist.size() != 0) {
			counter.counterUp(1);
			Knoten<T> tmp = head;
			while (tmp.getNext() != null) {
				counter.counterUp(1);
				tmp = tmp.getNext();
			}
			tmp.setNext(((Linkedlist<T>) otherlist).head.getNext());
			size = size + otherlist.size();
			counter.counterUp(1);
		} else {
			throw new NullPointerException();

		}
	}

	@Override
	public int size() {
		counter.counterUp(1);
		return size;
	}

	@Override
	public Counter getCounter() {
		return counter;
	}

}
