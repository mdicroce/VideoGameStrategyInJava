package grafics;

/**
 * Esta excepcion se lanza cuando un caracter no existe. Al constructor se le debe pasar un mensaje y el caracter.
 * @author Nahue
 *
 */

public class CaracterNoExisteException extends Exception{
	private char caracter;
	private String mensaje;
	
	public CaracterNoExisteException (char caracter,String mensaje) {
		super(mensaje);
		this.caracter = caracter;
	}
	
	public char getCaracter() {
		return caracter;
	}


}
