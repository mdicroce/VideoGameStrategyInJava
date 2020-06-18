package grafics;

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
