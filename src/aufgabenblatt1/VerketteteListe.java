package aufgabenblatt1;

import java.util.LinkedList;

public class VerketteteListe<T> implements Liste<T> {
	int anzahlDerElemnet;
	LinkedList list;
	T naechstesElement;
	T stopElement;

	/**
	 * Konstruktor
	 */
	public VerketteteListe() {
		anzahlDerElemnet = 0;
		list = new LinkedList();
		naechstesElement = null;
	}

	/**
	 * Getter
	 */
	public int getAnzahlDerElemnet() {
		return anzahlDerElemnet;
	}

	public LinkedList getList() {
		return list;
	}

	public T getNaechstesElement() {
		return naechstesElement;
	}

	public T getStopElement() {
		return stopElement;
	}

	public void setNaechstesElement(T naechstesElement) {
		this.naechstesElement = naechstesElement;
	}

	@Override
	public void insert(int pos, Object elem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public int find(Object elem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T retrieve(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concat(Liste otherlist) {
		VerketteteListe<T> otherlistV = (VerketteteListe<T>) otherlist;
		setNaechstesElement(otherlistV.stopElement);
	}

	@Override
	public int size() {
		return anzahlDerElemnet;
	}

}
