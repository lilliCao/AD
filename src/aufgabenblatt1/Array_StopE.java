package aufgabenblatt1;

import java.util.Arrays;

public class Array_StopE<T extends Comparable<T>> implements Liste<T> {
	private final int K;
	private int size;
	private Object[] array;
	private T stopE;

	/**
	 * Konstruktor
	 */
	@SuppressWarnings("unchecked")
	public Array_StopE(int length, int K) {
		this.K = K;
		this.size = 1;
		this.array = new Object[length];
		this.stopE = null;
		array[0] = stopE;
	}

	/**
	 * Getter
	 */

	public int getSize() {
		return (this.size - 1);
	}

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
	public boolean isValidPosition(int pos) {
		return (pos > 0 && pos <= size) ? true : false;
	}

	/**
	 * Diese Methode überprüft, ob ein Element null ist
	 * 
	 * @return true wenn es nicht null ist.
	 */
	public boolean isValidElement(T elem) {
		return (elem != null) ? true : false;
	}

	/**
	 * Diese Methode erhöht die Länge des Array um K. (K ist eine sinvolle
	 * Konstant)
	 */
	public void resize(Object[] array) {
		Object[] newArray = new Object[array.length + K];
		System.arraycopy(array, 0, newArray, 0, array.length);
		array = newArray;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (isValidElement(elem) && isValidPosition(pos)) {
			size++;
			if (size > array.length) {
				Object[] newArray = new Object[array.length + K];
				System.arraycopy(array, 0, newArray, 0, array.length);
				array = newArray;
			}
			if (array[pos] != null) {
				Object[] arrayC = new Object[array.length];
				System.arraycopy(array, 0, arrayC, 0, array.length);
				for (int i = pos + 1; i < size; i++) {
					array[i] = arrayC[i - 1];
				}
			}
			array[pos] = elem;
		} else {
			throw new UnvalidActionException("Ungültige Aktion: Element null oder ungültige Position");
		}

	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (!isValidPosition(pos)) {
			throw new IndexOutOfBoundsException();
		}
		size--;
		Object[] arrayC = new Object[array.length];
		System.arraycopy(array, 0, arrayC, 0, array.length);
		for (int i = pos; i < size; i++) {
			array[i] = arrayC[i + 1];
		}
		array[size] = null;

	}

	@Override
	public int find(T elem) {
		stopE = elem;
		for (int i = 1; i < size; i++) {
			if (array[i].equals(stopE)) {
				return i;
			}
		}
		return -1;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (!isValidPosition(pos)) {
			throw new IndexOutOfBoundsException();
		}
		return (T) array[pos];
	}

	@Override
	public void concat(Liste otherlist) {
		int lim = size + otherlist.size();
		if (lim > array.length) {
			Object[] newArray = new Object[array.length + K];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
		System.arraycopy(((Array_StopE) otherlist).array, 1, array, size, ((Array_StopE) otherlist).getSize());
	}

	@Override
	public int size() {
		return (this.size - 1);
	}

	

	public static void main(String[] args) throws UnvalidActionException {
		Array_StopE<Integer> test = new Array_StopE<Integer>(4, 10);
		if (test.getArray() instanceof Object[]) {
			System.out.println("Yes");
		}
		try {
			System.out.println(test.getSize());
			test.insert(1, 10);
			test.insert(2, 11);
			test.insert(3, 21);
			test.insert(3, 31);
			System.out.println(test.getSize());
			System.out.println(test.array.length);
			// test.insert(0, 41);
		} catch (UnvalidActionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.concat(test);
		System.out.println("E" + test.find(21));
		System.out.println("Elemente in der Liste");
		for (int i = 0; i < test.array.length; i++) {
			System.out.println(test.array[i]);
		}

	}

}
