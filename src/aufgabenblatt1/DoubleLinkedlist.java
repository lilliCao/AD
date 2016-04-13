package aufgabenblatt1;

import java.util.Arrays;

public class DoubleLinkedlist<T extends Comparable<T>> implements Liste<T> {
	private final int K;
	private int size;
	private Object[] array;
	private T stopE;

	/**
	 * Konstruktor
	 */
	public DoubleLinkedlist(int K) {
		this.K = K;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		// TODO Auto-generated method stub

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