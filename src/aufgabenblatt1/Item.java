package aufgabenblatt1;

public class Item<T> {
	private T content;
	private Item<T> nextItem;
	private Item<T> prevItem;

	/**
	 * Konstruktor
	 */
	public Item(T content, Item<T> prevItem, Item<T> nextItem) {
		this.content = content;
		this.prevItem = prevItem;
		this.nextItem = nextItem;
	}

	public Item() {
		this.content = null;
		this.nextItem = null;
		this.prevItem = null;
	}

	/**
	 * Getter
	 */
	public T getContent() {
		return content;
	}

	public Item<T> getPrevItem() {
		return prevItem;
	}

	public Item<T> getNextItem() {
		return nextItem;
	}

	/**
	 * Setter
	 */

	public void setContent(T content) {
		this.content = content;
	}

	public void setPrevItem(Item<T> prevItem) {
		this.prevItem = prevItem;
	}

	public void setNextItem(Item<T> nextItem) {
		this.nextItem = nextItem;
	}

}
