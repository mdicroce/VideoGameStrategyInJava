package Jugadores;

import Unidades.Unidad;

/**
 * Esta excepcion se lanza cuando no se puede agregar una unidad al cuartel. Al constructor se le debe pasar un mensaje y la unidad.
 * 
 * @author Nahue
 *
 */

public class ExceptionNoSePudoAgregar extends Exception{
	private Unidad unidad; 
	
	public ExceptionNoSePudoAgregar(String mensaje,Unidad unidad) {
		super(mensaje);
		this.unidad = unidad;
	}
	
	@Override
	public String getMessage() {
		
		return super.getMessage()+" "+unidad.toString();
	}
	

}
