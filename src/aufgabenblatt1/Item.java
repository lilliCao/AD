package aufgabenblatt1;

public class Item<T> {
	private T content;
	private int nextPos;
	private int prePos;

	/**
	 * Konstruktor
	 */
	public Item(T content, int pos) {
		this.content = content;
		this.prePos = pos - 1;
		this.nextPos = pos + 1;
	}

	public Item() {
		this.content = null;
		this.nextPos = 0;
		this.prePos = 0;
	}

	/**
	 * Getter
	 */
	public T getContent() {
		return content;
	}

	public int getPrePos() {
		return prePos;
	}

	public int getNextPos() {
		return nextPos;
	}

	/**
	 * Setter
	 */

	public void setContent(T content) {
		this.content = content;
	}

	public void setPos(int pos) {
		this.prePos = pos - 1;
		this.nextPos = pos + 1;
	}

}
