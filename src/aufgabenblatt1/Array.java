package aufgabenblatt1;

import static org.junit.Assert.assertEquals;

/**
 * Diese Klasse stellt eine Liste in einem Array dar.
 * 
 * @author cao
 *
 * @param <T>
 */
public class Array<T> implements Liste<T> {
	private final int K;
	private int size;
	private Object[] array;
	protected Counter counter;

	/**
	 * Konstruktor
	 */
	public Array(int K, int length) {
		this.K = K;
		this.size = 0;
		this.array = new Object[length];
		this.counter = new Counter();
	}

	/*
	 * Getter
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Object[] getArray() {
		return this.array;
	}

	public Counter getCounter() {
		return counter;
	}

	/**
	 * Diese Methode erhöht die Länge des Array um K. (K ist eine sinvolle
	 * Konstant)
	 */
	private void resize(Object[] array) {
		Object[] newArray = new Object[array.length + K];
		counter.counterUp(2); // Array erzeugen + länge berechnen
		System.arraycopy(this.array, 0, newArray, 0, array.length);
		counter.counterUp(array.length);
		this.array = newArray;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (pos >= 0 && pos <= size && elem != null) {
			if (size == array.length) {
				resize(array);
				counter.counterUp(1);
			}
			if (array[pos] != null) {
				counter.counterUp(1);
				for (int i = size; i > pos; i--) {
					array[i] = array[i - 1];
					counter.counterUp(1);
				}
			}
			array[pos] = elem;
			size++;
			counter.counterUp(2);
		} else {
			throw new UnvalidActionException("Ungültige Aktion: Element null oder ungültige Position");
		}

	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos < size) {
			counter.counterUp(1);
			for (int i = pos; i < size - 1; i++) {
				array[i] = array[i + 1];
				counter.counterUp(1);
			}
			array[size - 1] = null;
			size--;
			counter.counterUp(2);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int find(T elem) {
		for (int i = 0; i < size; i++) {
			counter.counterUp(1); // i erhöhen
			if (array[i].equals(elem)) {
				counter.counterUp(1);
				return i;
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos < size) {
			counter.counterUp(1);
			return (T) array[pos];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void concat(Liste otherlist) throws NullPointerException {
		if (otherlist != null && otherlist.size() != 0) {
			int newsize = size + otherlist.size();
			counter.counterUp(2);
			while (newsize > array.length) {
				resize(this.array);
			}
			System.arraycopy(((Array) otherlist).array, 0, array, size, otherlist.size());
			counter.counterUp(otherlist.size() + 1);
			size = newsize;

		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public int size() {
		counter.counterUp(1);
		return this.size;
	}

}
