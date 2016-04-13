package aufgabenblatt1;

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

	/**
	 * Getter
	 */

	public int getSize() {
		return this.size;
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
	private boolean isValidPosition(int pos) {
		return (pos >= 0 && pos <= size) ? true : false;
	}

	/**
	 * Diese Methode überprüft, ob ein Element null ist
	 * 
	 * @return true wenn es nicht null ist.
	 */
	private boolean isValidElement(T elem) {
		return (elem != null) ? true : false;
	}

	/**
	 * Diese Methode erhöht die Länge des Array um K. (K ist eine sinvolle
	 * Konstant)
	 */
	private void resize(Object[] array) {
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
		if (!isValidPosition(pos)) {
			throw new IndexOutOfBoundsException();
		}
		return (T) array[pos];
	}

	@Override
	public void concat(Liste otherlist) throws NullPointerException {
	if (otherlist ==null){
			throw new NullPointerException();
	}
			int lim = size + ((Array) otherlist).size;
			if (lim > array.length) {
				Object[] newArray = new Object[array.length + K];
				System.arraycopy(array, 0, newArray, 0, array.length);
				array = newArray;
			}
			System.arraycopy(((Array) otherlist).array, 0, array, size, ((Array) otherlist).getSize());
	
	}

	@Override
	public int size() {
		return this.size;
	}

	public static void main(String[] args) throws UnvalidActionException {
		Array<Integer> test = new Array<Integer>(4, 10);
		if (test.getArray() instanceof Object[]) {
			System.out.println("Yes");
		}
		try {
			test.insert(0, 10);
			test.insert(0, 11);
			test.insert(0, 21);
			// test.insert(0, 31);
			System.out.println(test.size);
			System.out.println(test.array.length);
			// test.insert(0, 41);
		} catch (UnvalidActionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// test.concat(test);
		// System.out.println("Elemente in der Liste");
		// for (int i = 0; i < test.array.length; i++) {
		// System.out.println(test.array[i]);
		// }

	}
}
