package aufgabenblatt1;

import java.io.ObjectInputStream.GetField;
import java.util.LinkedList;

public class VerketteteListe<T> implements Liste<T> {
	int anzahlDerElemnet;
	LinkedList<T> list;
	T stopElement;

	/**
	 * 
	 * Konstruktor
	 */
	public VerketteteListe() {
		anzahlDerElemnet = 0;
		list = new LinkedList<T>();
	}

	/**
	 * Getter
	 */
	public int getAnzahlDerElemnet() {
		return anzahlDerElemnet;
	}

	public LinkedList<T> getList() {
		return list;
	}

	public T getStopElement() {
		return stopElement;
	}

	public void setStopElement(T stopElement) {
		this.stopElement = stopElement;
	}

	@Override
	public void insert(int pos, Object elem) throws IndexOutOfBoundsException {
		//list.add(pos, (T) elem);

		
		
		
		
	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (list.get(pos) != null) {
			anzahlDerElemnet--;
		}
		list.set(pos, null);
	}

	@Override
	public int find(Object elem) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(elem)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		return (T) list.get(pos);

	}

	@Override
	public void concat(Liste otherlist) {
		VerketteteListe<T> otherlistV = (VerketteteListe<T>) otherlist;
		setStopElement((T) otherlistV.list.getFirst());
	}

	@Override
	public int size() {
		return anzahlDerElemnet;
	}
public static void main(String[] args) {
	 VerketteteListe<Integer> test = new VerketteteListe<Integer>();
test.insert(0, 0);
test.insert(1, 10);
test.insert(2, 11);
System.out.println(test.list.get(0));
System.out.println(test.list.get(1));
System.out.println(test.list.get(2));
System.out.println("!!!");
test.delete(1);
//test.insert(1, 1);
System.out.println(test.list.get(0));
System.out.println(test.list.get(1));
System.out.println(test.list.get(2));



}
}
