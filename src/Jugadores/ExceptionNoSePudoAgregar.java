package Jugadores;

import Unidades.Unidad;

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
