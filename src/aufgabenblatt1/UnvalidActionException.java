package aufgabenblatt1;

public class UnvalidActionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UnvalidActionException (String message){
	super("Element ist null oder die Position ist außer gültiger Bereich (von 0 bis size) ");	
	}

}
