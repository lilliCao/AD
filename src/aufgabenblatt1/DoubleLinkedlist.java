package aufgabenblatt1;

import java.util.Arrays;

public class DoubleLinkedlist<T extends Comparable<T>> implements Liste<T> {
	private int size;
	private Item<T> head;
	private Item<T> tail;
	private Object[] array;

	/**
	 * Konstruktor
	 */
	public DoubleLinkedlist() {
		this.size = 0;
		this.head = new Item();
		this.tail = new Item();
		this.head.setNextItem(tail);
		this.tail.setPrevItem(head);
		this.array = new Object[100];
	}

	/**
	 * Getter
	 */
	public Item<T> getHead() {
		return head;
	}

	public Item<T> getTail() {
		return tail;
	}

	public void setTail(Item<T> tail) {
		this.tail = tail;
	}

	private Item<T> itemAnDerVorPos(int pos) {
		Item<T> tmp = new Item<T>();
		if (pos <= size / 2) {
			tmp = head;
			for (int i = 0; i < pos; i++) {
				tmp = tmp.getNextItem();
			}
		} else {
			tmp = tail;
			for (int i = size + 1; i > pos; i--) {
				tmp = tmp.getPrevItem();
			}
		}
		return tmp;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (pos >= 0 && pos <= size && elem != null) {
			Item<T> insertItem = new Item(elem, null, null);
			Item<T> tmp = itemAnDerVorPos(pos);
			Item<T> tmp2 = tmp.getNextItem();

			insertItem.setNextItem(tmp2);
			insertItem.setPrevItem(tmp);
			tmp2.setPrevItem(insertItem);
			tmp.setNextItem(insertItem);
			size++;
			// array[pos] = elem;
		} else {
			throw new UnvalidActionException("Ungültige Aktion: Element null oder ungültige Position");
		}
	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos < size) {
			Item<T> tmp = itemAnDerVorPos(pos);
			Item<T> tmp2 = tmp.getNextItem().getNextItem();
			tmp.setNextItem(tmp2);
			tmp2.setPrevItem(tmp);
			size--;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int find(T elem) {
		Item<T> tmp = new Item<T>();
		tmp = this.head.getNextItem();
		for (int i = 0; i < size; i++) {
			if (tmp.getContent().equals(elem)) {
				return i;
			}
			tmp = tmp.getNextItem();

		}
		return -1;
	}

	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos < size) {
			return itemAnDerVorPos(pos + 1).getContent();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void concat(Liste otherlist) throws NullPointerException {
		if (otherlist != null && otherlist.size() != 0) {
			DoubleLinkedlist<T> otherlistTmp = (DoubleLinkedlist<T>) otherlist;

			this.tail.getPrevItem().setNextItem(otherlistTmp.getHead().getNextItem());
			otherlistTmp.getHead().getNextItem().setPrevItem(this.tail.getPrevItem());
			setTail(otherlistTmp.getTail());
			size = size + otherlist.size();
		} else {
			throw new NullPointerException();
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Counter getCounter() {
		// TODO Auto-generated method stub
		return null;
	}

}