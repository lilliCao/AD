package aufgabenblatt1;

public class ArrayElement<T> {
	private T content;
	private int index;
	private int prevIndex;
	private int nextIndex;
	// Constructor

	public ArrayElement(T content, int index, int prevIndex, int nextIndex) {
		this.content = content;
		this.index = index;
		this.prevIndex = prevIndex;
		this.nextIndex = nextIndex;
	}

	// Getter and Setter
	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPrevIndex() {
		return prevIndex;
	}

	public void setPrevIndex(int prevIndex) {
		this.prevIndex = prevIndex;
	}

	public int getNextIndex() {
		return nextIndex;
	}

	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}

}
