package tateti;

public class FichaNoValidaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FichaNoValidaException(){
        super("No se puede ingresar una ficha con ese id");
    }
}
