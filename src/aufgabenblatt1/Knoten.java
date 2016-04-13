package aufgabenblatt1;

public class Knoten<T> implements Liste<T> {
	private int size;
	private Knoten<T> next;
	private T content;

	/**
	 * Constructor
	 */
	public Knoten(T content) {
		this.size = 1;
		this.next = null;
		this.content = content;
	}

	public Knoten(T content, Knoten<T> knoten) {
		this(content);
		size ++;
		next = knoten;
	}

	/**
	 * Getter
	 * 
	 * @return
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

	public void setContent(Knoten<T> knoten) {
		this.content = knoten.content;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (pos >  0 && pos <= size) {
			size++;
			if (next == null) {
				setNext(new Knoten<T>(elem));
			} else {
				Knoten<T> last = next;
				Knoten<T> tmp = null;
				while (last != null) {
					tmp = last.next;
					last = last.getNext();
				}
				tmp.setNext(new Knoten<T>(elem));
			}
		}
		throw new UnvalidActionException("ungültige Position");
	}

	@Override
	public void delete(int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public int find(T elem) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return this.size;
	}

	public static void main(String[] args) throws UnvalidActionException {
		Knoten<Integer> test = new Knoten<Integer>(12);
		System.out.println(test.getContent());
		System.out.println(test.getNext());
		test.insert(1, 16);
		// System.out.println(test.next.getContent());
		// System.out.println(test.next.next.getContent());

	}

}
