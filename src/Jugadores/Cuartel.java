package Jugadores;

/**
 * Clase Cuartel la cual es un contenedor generico de unidades. 
 * 
 * 
 * @author Nahuel Flores
 *
 */

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import Unidades.Infanteria;
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
					}
				}
				
				if (fueEliminado == false) {
					throw new ExceptionNoExiste("El elemento que usted desea eliminar no existe");	
				}
		}
			
		return fueEliminado;
	}
	
	public void eliminar(T eliminar) throws ExceptionNoExiste,ExceptionEstaVacio{
		boolean fueEliminado = false;
		
		if (cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		}
		else {
					
				for (T unidad : cuartel) {
					if(unidad.equals(eliminar)) {
						fueEliminado = cuartel.remove(unidad);
					}
				}
				
				if (fueEliminado == false) {
					throw new ExceptionNoExiste("El elemento que usted desea eliminar no existe");	
				}
		}	
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
					
				}
				
				if(buscado == null) {
					throw new ExceptionNoExiste("El elemento que busco no existe");
				
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
					
				}
				
				if(buscado == null) {
					throw new ExceptionNoExiste("El elemento que busco no existe");
				
				}
		}
			
		return buscado;
	}
	
	public JSONArray toJsonArray() throws JSONException {
		JSONArray jsonArray = new JSONArray();
		int i = 0;

		for (Unidad unidad : cuartel) {
			
			if (unidad instanceof Infanteria) {//Esto se realiza ya que la infanteria tiene un toJson diferente
				Infanteria infanteria = (Infanteria) unidad;
				jsonArray.put(i, infanteria.toJson()); 
			}else {
				jsonArray.put(i, unidad.toJson());
			} 
			
			i++;	
		}
		
		return jsonArray;
	}
}
