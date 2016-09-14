package aufgabenblatt1;

public class ArrayLink<T extends Comparable<T>> implements Liste<T> {
	private int size;
	private final int K;
	private Object[] array;
	private int indexOfHead;

	// Constructor
	public ArrayLink(int K, int length) {
		this.K = K;
		this.size = 0;
		this.array = new Object[length];
		this.indexOfHead = -1;

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

	/**
	 * Diese Methode liefert die erste freie Position in dem Array Falls die
	 * Array voll ist, wird die Länge der Array um K erhöht
	 */
	private int getFirstFreeArrayPosition() {
		int i;
		for (i = 0; i < array.length; i++) {
			if (array[i] == null) {
				return i;
			}
		}
		resize(array);
		return i + 1;
	}

	/**
	 * Diese Methode liefert das ArrayElement an der eingegebenen Position
	 */
	private ArrayElement<T> getArrayElementAt(int pos) {
		ArrayElement<T> arrayElement = (ArrayElement<T>) array[indexOfHead];
		for (int i = 0; i < pos; i++) {
			arrayElement = (ArrayElement<T>) array[arrayElement.getNextIndex()];
		}
		return arrayElement;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (pos < 0 || pos > size || elem == null) {
			throw new UnvalidActionException("Ungültige Aktion");
		}
		// erster Element
		if (size == 0) {
			array[0] = new ArrayElement<T>(elem, 0, -1, -1);
			indexOfHead = 0;
			size++;
			return;
		}

		int arrayIndexOfInsertElement = getFirstFreeArrayPosition();
		int prevIndexOfInsertElement = -1;
		int nextIndexOfInsertElement = -1;
		// am Anfang einfügen
		if (pos == 0) {

			ArrayElement<T> head = getArrayElementAt(pos);
			head.setPrevIndex(arrayIndexOfInsertElement);
			nextIndexOfInsertElement = head.getIndex();
			indexOfHead = arrayIndexOfInsertElement;
		}
		// am Ende einfügen
		else if (pos == size) {
			ArrayElement<T> tail = getArrayElementAt(pos - 1);
			tail.setNextIndex(arrayIndexOfInsertElement);
			prevIndexOfInsertElement = tail.getIndex();
		}
		// mitte einfügen
		else {
			ArrayElement<T> elementAtPosition = getArrayElementAt(pos);
			ArrayElement<T> elementBeforePosition = (ArrayElement<T>) array[elementAtPosition.getPrevIndex()];
			elementBeforePosition.setNextIndex(arrayIndexOfInsertElement);
			elementAtPosition.setPrevIndex(arrayIndexOfInsertElement);
			prevIndexOfInsertElement = elementBeforePosition.getNextIndex();
			nextIndexOfInsertElement = elementAtPosition.getPrevIndex();
		}
		array[arrayIndexOfInsertElement] = new ArrayElement<T>(elem, arrayIndexOfInsertElement,
				prevIndexOfInsertElement, nextIndexOfInsertElement);
		size++;
	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		ArrayElement<T> tmp = getArrayElementAt(pos);
		// nur ein Element
		if (size == 1) {
			indexOfHead = -1;
		}
		// delete 1.Element
		else if (pos == 0) {
			ArrayElement<T> elementAfterPosition = (ArrayElement<T>) array[tmp.getNextIndex()];
			elementAfterPosition.setNextIndex(-1);
			indexOfHead = elementAfterPosition.getIndex();
		} // delete last Element
		else if (pos == size - 1) {
			ArrayElement<T> elementBeforePosition = (ArrayElement<T>) array[tmp.getPrevIndex()];
			elementBeforePosition.setNextIndex(-1);
		} // delete spontanous element
		else {
			ArrayElement<T> elementAfterPosition = (ArrayElement<T>) array[tmp.getNextIndex()];
			ArrayElement<T> elementBeforePosition = (ArrayElement<T>) array[tmp.getPrevIndex()];
			elementBeforePosition.setNextIndex(elementAfterPosition.getIndex());
			elementAfterPosition.setPrevIndex(elementBeforePosition.getIndex());

		}
		array[tmp.getIndex()] = null;
		size--;

	}

	@Override
	public int find(T elem) {
		ArrayElement<T> arrayElement = (ArrayElement<T>) array[indexOfHead];
		for (int i = 0; i < size; i++) {
			if (arrayElement.getContent().equals(elem)) {
				return i;
			}
			arrayElement = (ArrayElement<T>) array[arrayElement.getNextIndex()];
		}
		return -1;
	}

	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		return getArrayElementAt(pos).getContent();
	}

	@Override
	public void concat(Liste otherlist) throws NullPointerException {
		if (otherlist != null && otherlist.size() != 0) {
			int newsize = size + otherlist.size();
			while (newsize > array.length) {
				resize(this.array);
			}
			// System.arraycopy(((ArrayLink) otherlist).array, 0, array, size,
			// otherlist.size());
			for (int i = 0; i < otherlist.size(); i++) {
				try {
					insert(this.size, (T) otherlist.retrieve(i));
				} catch (IndexOutOfBoundsException | UnvalidActionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			size = newsize;
		} else {
			throw new NullPointerException();
		}

	}

	@Override
	public int size() {
		return size;
	}

}
