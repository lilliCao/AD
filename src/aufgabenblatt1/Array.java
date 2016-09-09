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

	/**
	 * Konstruktor
	 */
	public Array(int K, int length) {
		this.K = K;
		this.size = 0;
		this.array = new Object[length];

	}

	/*
	 * Getter
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Object[] getArray() {
		return this.array;
	}

	/**
	 * Diese Methode erhöht die Länge des Array um K. (K ist eine sinvolle
	 * Konstant)
	 */
	private void resize(Object[] array) {
		Object[] newArray = new Object[array.length + K];
		System.arraycopy(this.array, 0, newArray, 0, array.length);
		this.array = newArray;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (pos >= 0 && pos <= size && elem != null) {
			if (size > array.length) {
				resize(array);
			}
			if (array[pos] != null) {
				for (int i = size; i > pos; i--) {
					array[i] = array[i - 1];
				}
			}
			array[pos] = elem;
			size++;
		} else {
			throw new UnvalidActionException("Ungültige Aktion: Element null oder ungültige Position");
		}

	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos < size) {
			for (int i = pos; i < size - 1; i++) {
				array[i] = array[i + 1];
			}
			array[size - 1] = null;
			size--;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int find(T elem) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(elem)) {
				return i;
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos < size) {
			return (T) array[pos];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void concat(Liste otherlist) throws NullPointerException {
		if (otherlist != null && otherlist.size() != 0) {
			int newsize = size + otherlist.size();
			while (newsize > array.length) {
				resize(this.array);
			}
			System.arraycopy(((Array) otherlist).array, 0, array, size, otherlist.size());
			size = newsize;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public int size() {
		return this.size;
	}

}
