package Jugadores;

/**
 * Esta excepcion se lanza cuando no se encuentra un objeto en un contenedor.
 * @author Nahue
 *
 */
public class ExceptionNoExiste extends Exception{

	public ExceptionNoExiste(String s) {
		super(s);
	}
}
