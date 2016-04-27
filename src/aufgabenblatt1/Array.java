package aufgabenblatt1;

import static org.junit.Assert.assertEquals;

public class Array<T> implements Liste<T> {
	private final int K;
	private int size;
	private Object[] array;

	/**
	 * Konstruktor
	 */
	public Array(int length, int K) {
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
	 * Diese Methode überprüft eine eingegebene Position, ob man ein Element an
	 * der Position hinzufügen darf. Die Position ist gültig von 0 bis size
	 * 
	 * @return true oder false
	 */

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
			size++;
			if (size > array.length) {
				resize(array);
			}
			if (array[pos] != null) {
				// Object[] arrayC = new Object[array.length];
				// System.arraycopy(array, 0, arrayC, 0, array.length);
				for (int i = size-1; i > pos; i--) {
					array[i] = array[i - 1];
				}
			}
			array[pos] = elem;
		} else {
			throw new UnvalidActionException("Ungültige Aktion: Element null oder ungültige Position");
		}

	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		size--;
		if (pos != size - 1) {
			Object[] arrayC = new Object[array.length];
			System.arraycopy(array, 0, arrayC, 0, array.length);
			for (int i = pos; i < size; i++) {
				array[i] = arrayC[i + 1];
			}
		}
		array[size] = null;

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
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		return (T) array[pos];
	}

	@Override
	public void concat(Liste otherlist) throws NullPointerException {
		if (otherlist == null || otherlist.size() == 0) {
			throw new NullPointerException();
		}
		int lim = size + otherlist.size();
		while (lim > array.length) {
			resize(this.array);
		}
		System.arraycopy(((Array) otherlist).array, 0, array, size, otherlist.size());
		size = size + otherlist.size();
	}

	@Override
	public int size() {
		return this.size;
	}

}
