package Jugadores;

import java.util.ArrayList;

import Unidades.Unidad;

public class Cuartel <T extends Unidad > {
	private ArrayList<T> cuartel;
	
	
	public Cuartel(){
		
		cuartel = new ArrayList<T>();
		
	}	
	
	public boolean agregar(T unidad) {
		
		return cuartel.add(unidad);
	}
	
	public boolean eliminar(int id) throws ExceptionNoExiste,ExceptionEstaVacio{
		boolean fueEliminado = false;
		
		if (cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		}
		else {
					
				for (T unidad : cuartel) {
					if(unidad.getId() == id) {
						fueEliminado = cuartel.remove(unidad);
					}else {
						throw new ExceptionNoExiste("El elemento que busco no existe");
					
					}
				}		
		}
			
		return fueEliminado;
	}
	
	public boolean eliminar(T eliminar) throws ExceptionNoExiste,ExceptionEstaVacio{
		boolean fueEliminado = false;
		
		if (cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		}
		else {
					
				for (T unidad : cuartel) {
					if(unidad.equals(eliminar)) {
						fueEliminado = cuartel.remove(unidad);
					}
					else {
						throw new ExceptionNoExiste("El elemento que busco no existe");
					
					}
				}		
		}
			
		return fueEliminado;
	}
	
	public T buscar(int id)  throws ExceptionNoExiste,ExceptionEstaVacio {
		T buscado = null;
		
		if (cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		}
		else {
					
				for (T unidad : cuartel) {
					if(unidad.getId() == id) {
						buscado = unidad;
					}
					else {
						throw new ExceptionNoExiste("El elemento que busco no existe");
					
					}
				}		
		}
			
		return buscado;
	}
	
	public T buscar(T buscar) throws ExceptionNoExiste,ExceptionEstaVacio {
		T buscado = null;
		
		if (cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		}
		else {
					
				for (T unidad : cuartel) {
					if(unidad.equals(buscar)) {
						buscado = unidad;
					}
					else {
						throw new ExceptionNoExiste("El elemento que busco no existe");
					
					}
				}		
		}
			
		return buscado;
	}
}
