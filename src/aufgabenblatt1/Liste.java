package aufgabenblatt1;

public interface Liste<T> {
	/**
	 * Diese Methode f�gt ein neues Element an einer bestimmten Position in der
	 * Liste
	 * @throws UnvalidActionException  
	 * wenn das Element null ist oder die Position ung�ltig ist.
	 */
	public void insert(int pos, T elem) throws UnvalidActionException ;

	/**
	 * Diese Methode l�scht das Element an einer bestimmten Position in der
	 * Liste
	 */
	public void delete(int pos);

	/**
	 * Diese Methode sucht ein Element in der Liste und liefert die Position des
	 * gefundenes Element zur�ck
	 * Wenn das Element liegt nicht an der Liste, liefert -1 zur�ck.
	 */
	public int find(T elem);

	/**
	 * Diese Methode sucht das Element an einer bestimmten Position in der Liste
	 * und liefert es zur�ck
	 */
	public T retrieve(int pos);

	/**
	 * Diese Methode verkn�pft zwei Liste mit einander
	 */
	public void concat(Liste otherlist);

	/**
	 * Diese Methode berechnet die Gr��e einer Liste (Anzahl der richtigen Element in der
	 * Liste )
	 */
	public int size ();
}
