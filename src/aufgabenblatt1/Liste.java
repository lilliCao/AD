package aufgabenblatt1;

public interface Liste<T> {
	/**
	 * Diese Methode fügt ein neues Element an einer bestimmten Position in der
	 * Liste
	 * @throws UnvalidActionException  
	 * wenn das Element null ist oder die Position ungültig ist.
	 */
	public void insert(int pos, T elem) throws UnvalidActionException ;

	/**
	 * Diese Methode löscht das Element an einer bestimmten Position in der
	 * Liste
	 */
	public void delete(int pos);

	/**
	 * Diese Methode sucht ein Element in der Liste und liefert die Position des
	 * gefundenes Element zurück
	 * Wenn das Element liegt nicht an der Liste, liefert -1 zurück.
	 */
	public int find(T elem);

	/**
	 * Diese Methode sucht das Element an einer bestimmten Position in der Liste
	 * und liefert es zurück
	 */
	public T retrieve(int pos);

	/**
	 * Diese Methode verknüpft zwei Liste mit einander
	 */
	public void concat(Liste otherlist);

	/**
	 * Diese Methode berechnet die Größe einer Liste (Anzahl der richtigen Element in der
	 * Liste )
	 */
	public int size ();
}
