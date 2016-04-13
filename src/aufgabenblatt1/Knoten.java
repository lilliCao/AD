package aufgabenblatt1;

public class Knoten<T> {

	private Knoten<T> next;
	private T content;

	/**
	 * Constructor
	 */
	public Knoten(T content) {
		this.next = null;
		this.content = content;
	}

	/**
	 * Getter
	 * 
	 */

	public Knoten<T> getNext() {
		return next;
	}

	public T getContent() {
		return content;
	}

	/**
	 * Setter
	 */

	public void setNext(Knoten<T> knoten) {
		this.next = knoten;
	}

	public void setContent(T content) {
		this.content = content;
	}

}
