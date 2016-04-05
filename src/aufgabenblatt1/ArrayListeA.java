package aufgabenblatt1;

public class ArrayListeA<T> implements Liste<T> {
	private int size;
	private int belegterPlatz;
	private Object[] array;

	/**
	 * Konstruktor
	 */
	public ArrayListeA(int size) {
		this.size = size;
		this.belegterPlatz = 0;
		this.array = new Object[size];

	}

	/**
	 * Getter
	 */
	public int getSize() {
		return this.size;
	}

	public int getBelegterPlatz() {
		return this.belegterPlatz;
	}

	public Object[] getArray() {
		return this.array;
	}

	public int[] freiStelle() {
		int[] listeDerFreieStelle = new int[array.length];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				listeDerFreieStelle[j] = i;
				j++;
			}
		}
		return listeDerFreieStelle;
	}
public int naechsteFreiStelle(){
	int j =0;
	for(int i =0; i< array.length; i++){
		if(array[i] == null){
			j=i;
			break;
		}
	}
	return j;
}
	
	@Override
	public void insert(int pos, T elem) throws IndexOutOfBoundsException {
		if (array[pos] == null) {
			array[pos] = (Object) elem;
		} else {
			Object[] arrayVerlaengern = new Object[array.length * 2];
			System.arraycopy(array, 0, arrayVerlaengern, 0, pos);
			System.arraycopy(array, pos, arrayVerlaengern, pos + 1, array.length - pos);
			arrayVerlaengern[pos] = (Object) elem;
			array = arrayVerlaengern;
		}

		belegterPlatz++;

	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (array[pos] != null) {
			belegterPlatz--;
		}
		array[pos] = null;
	}

	@Override
	public int find(T elem) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(elem)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		return (T) array[pos];
	}

	@Override
	public void concat(Liste otherlist) {
		Object[] arrayVerlaengern = new Object[size + otherlist.size()];
		ArrayListeA otherlistA = (ArrayListeA) otherlist;
		
		System.arraycopy(array, 0, arrayVerlaengern, 0, size);
		System.arraycopy(otherlistA.getArray(), 0, arrayVerlaengern, array.length, otherlist.size());
		
		array = arrayVerlaengern;
		belegterPlatz = belegterPlatz + ((ArrayListeA) otherlist).belegterPlatz;
	}

	@Override
	public int size() {
		return this.belegterPlatz;
	}
public static void main(String[] args) {
	ArrayListeA<Integer> test = new ArrayListeA<Integer>(6);
	test.insert(0, 0);
	test.insert(5, 5);
	test.insert(4, 4);
	System.out.println(test.naechsteFreiStelle());
}
}
