package aufgabenblatt1;

public interface Liste<T> {
	/**
	 * Diese Methode f�gt ein neues Element an einer bestimmten Position in der
	 * Liste
	 * 
	 * @throws UnvalidActionException
	 *             wenn das Element null ist oder die Position ung�ltig ist.
	 */
	public void insert(int pos, T elem) throws UnvalidActionException;

	/**
	 * Diese Methode l�scht das Element an einer bestimmten g�ltigen Position in
	 * der Liste.(von 0 bis size)
	 * 
	 * @throws IndexOutOfBoundsException
	 *             wenn die Position ung�ltig ist.
	 */
	public void delete(int pos) throws IndexOutOfBoundsException;

	/**
	 * Diese Methode sucht ein Element in der Liste und liefert die Position des
	 * gefundenes Element zur�ck Wenn das Element liegt nicht an der Liste,
	 * liefert -1 zur�ck.
	 */
	public int find(T elem);

	/**
	 * Diese Methode sucht das Element an einer bestimmten Position in der Liste
	 * und liefert es zur�ck
	 * 
	 * @throws IndexOutOfBoundsException
	 *             wenn die Position ung�ltig ist.
	 */
	public T retrieve(int pos) throws IndexOutOfBoundsException;

	/**
	 * Diese Methode verkn�pft zwei Liste mit einander. Alle Elementen von
	 * eingegebenen Liste werden am Ende des Original-liste angeh�ngt.
	 * 
	 * @throws NullPointerException
	 *             wenn die zu concat Liste null ist order keine Elemente
	 *             enth�lt.
	 */
	public void concat(Liste<T> otherlist) throws NullPointerException;

	/**
	 * Diese Methode berechnet die Gr��e einer Liste (Anzahl der Element in der
	 * Liste )
	 */
	public int size();

	/**
	 * Diese Methode liefert Anzahl der Operationen
	 * 
	 * @return
	 */
	public Counter getCounter();
}
