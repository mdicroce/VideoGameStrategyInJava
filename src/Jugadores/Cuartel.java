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
	
	public boolean eliminar(int id) {
		boolean fueEliminado = false;
		
		if (cuartel.isEmpty() == false) {
					
				for (T unidad : cuartel) {
					if(unidad.getId() == id) {
						fueEliminado = cuartel.remove(unidad);
					}
				}		
		}
			
		return fueEliminado;
	}
	
}
