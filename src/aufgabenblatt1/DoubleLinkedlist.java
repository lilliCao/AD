package aufgabenblatt1;

import java.util.Arrays;

public class DoubleLinkedlist<T extends Comparable<T>> implements Liste<T> {
	private final int K;
	private int size;
	private Object[] array;
	private Item stopE;

	/**
	 * Konstruktor
	 */
	public DoubleLinkedlist(int K, int length) {
		this.K = K;
		this.size = 0;
		this.array = new Object[length];
		this.stopE = new Item();
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
		if (pos < 0 || pos > size || elem == null) {
			throw new UnvalidActionException("Ungültige Aktion: Element null oder ungültige Position");
		}
		

	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public int find(T elem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concat(Liste otherlist) throws NullPointerException {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}