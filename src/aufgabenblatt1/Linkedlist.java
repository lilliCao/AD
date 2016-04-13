package aufgabenblatt1;

public class Linkedlist<T> implements Liste<T> {
	private int size;
	private Knoten<T> first;

	/**
	 * Konstruktor
	 */
	public Linkedlist(Knoten<T> knoten) {
		this.size = 1;
		this.first = knoten;
	}


	/**
	 * Getter
	 */
	public Knoten<T> getHead() {
		return first;
	}

	/**
	 * Setter
	 */
	public void setHead(Knoten<T> knoten) {
		this.first = knoten;
	}

	@Override
	public void insert(int pos, T elem) throws UnvalidActionException {
		if (pos > 0 && pos >= size + 1 && elem != null) {
		if(pos == size +1){
			Knoten<T> last = first;
			Knoten<T> tmp = last;
			while( last.getNext() !=null){
				tmp = last;
				last = last.getNext();
			}
			last.setNext(new Knoten(elem));
		}
		
		}
		throw new UnvalidActionException("Ungültige Position oder ungültiges Element");
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
		return size;
	}

}
