package Jugadores;

/**
 * Clase Cuartel la cual es un contenedor generico de unidades. 
 * 
 * 
 * @author Nahuel Flores
 *
 */

import java.util.ArrayList;
import Mapa.Celda;
import Unidades.Unidad;

/**
 * Esta clase almacenara los objetos que extiendan de Unidad en un ArrayList.
 * Ademas podremos Agregar,Eliminar,Buscar, pasar todo a un objeto JSonArray y pasar lo de un JSonArray
 * a un ArrayList. 
 * @author Nahue
 *
 * @param <T> Es cualquier objeto que extienda de Unidad.
 */

public class Cuartel<T extends Unidad> {
	private ArrayList<T> cuartel;

	public Cuartel() {

		cuartel = new ArrayList<T>();

	}
// -------------------------------------GETTERS--------------------------------------------//
	
	public ArrayList<T> getCuartel() {
		return cuartel;
	}
	
	public int getValidos() {
		return cuartel.size();
	}

// -------------------------------------SETTERS--------------------------------------------//
	
	public void setCuartel(ArrayList<T> cuartel) {
		this.cuartel = cuartel;
	}
	
// -------------------------------------METODOS PROPIOS-------------------------------------//

/**
 * Agrega un elemento al ArrayList.
 * @param unidad elemento a agregar.
 *
 * @throws ExceptionNoSePudoAgregar se lanza cuando la unidad no fue agregada.
 */

	public void agregar(T unidad) throws ExceptionNoSePudoAgregar {
		if (cuartel.add(unidad)==false) {
			throw new ExceptionNoSePudoAgregar("No se pudo agregar", unidad);
		} 
	}


/**
 * Elimina un elemento del Arraylist buscandolo mediante la comparacion con el objeto pasado por parametro.
 * @param eliminar objeto que extiende de Unidad a eliminar.
 * @throws ExceptionNoExiste se lanza cuando no existe el elemento.
 * @throws ExceptionEstaVacio se lanza cuando el ArrayList esta vacio.
 */
	
	public void eliminar(T eliminar) throws ExceptionNoExiste, ExceptionEstaVacio {
		boolean fueEliminado = false;

		if (cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		} else {

			for (T unidad : cuartel) {
				if (unidad.equals(eliminar)) {
					fueEliminado = cuartel.remove(unidad);
				}
			}

			if (fueEliminado == false) {
				throw new ExceptionNoExiste("El elemento que usted desea eliminar no existe");
			}
		}
	}
	
/**
 * Busca un elemento del Arraylist buscandolo mediante su celda pasado por parametro.
 * @param id identificador del tipo int.
 * @return Objeto del tipo Unidad buscado.
 * @throws ExceptionNoExiste se lanza cuando no existe un elemento con ese ID.
 * @throws ExceptionEstaVacio se lanza cuando el ArrayList esta vacio.
 * 
 */
	public T buscar(Celda posicion) throws ExceptionNoExiste, ExceptionEstaVacio {
		T buscado = null;

		if (cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		} else {

			for (T unidad : cuartel) {
				if (posicion.equals(unidad.getPosicion())) {
					buscado = unidad;
				}

			}

			if (buscado == null) {
				throw new ExceptionNoExiste("No hay ningun elemento que tenga esa posicion");

			}
		}

		return buscado;
	}
	
	
/**
 * Busca un elemento del Arraylist buscandolo mediante la comparacion con el objeto pasado por parametro.
 * 
 * @param buscar objeto que extiende de Unidad a buscar.
 * @return Objeto del tipo Unidad buscado.
 * @throws ExceptionNoExiste se lanza cuando no existe en el arreglo el elemento pasado por parametro.
 * @throws ExceptionEstaVacio se lanza cuando el ArrayList esta vacio.
 */

	public T buscar(T buscar) throws ExceptionNoExiste, ExceptionEstaVacio {
		T buscado = null;

		if (cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		} else {

			for (T unidad : cuartel) {
				if (unidad.equals(buscar)) {
					buscado = unidad;
				}

			}

			if (buscado == null) {
				throw new ExceptionNoExiste("El elemento que busco no existe");

			}
		}

		return buscado;
	}
	
	
	/**
	 * Busca un elemento del Arraylist buscandolo mediante la posicion pasada por parametro.
	 * 
 	 * @param pos posicion del tipo int del objeto que se quiere buscar.
	 * @return Objeto del tipo Unidad buscado.
	 * @throws ExceptionNoExiste se lanza cuando no existe un elemento en la posicion pasada por parametro.
	 * @throws ExceptionEstaVacio se lanza cuando el ArrayList esta vacio.
	 */
	
	public T buscar(int pos) throws ExceptionNoExiste, ExceptionEstaVacio {
		
		if(cuartel.isEmpty()) {
			throw new ExceptionNoExiste("El cuartel esta vacio");
		}
		else {
			
			if (pos>=getValidos()) {
				throw new ExceptionNoExiste("El elemento que busco no existe");
			} else {
				return cuartel.get(pos);
			}
		}
	}
	
	/**
	 * Lista el cuartel unidad por unidad y almacena cada toString de la unidad en una posicion del ArrayList.
	 * @return un ArrayList de Strings con los toStrings de cada una de las unidades del cuartel.
	 * @throws ExceptionEstaVacio se lanza cuando el ArrayList esta vacio.
	 */
	public ArrayList<String> listar() throws ExceptionEstaVacio{
		Unidad unidad;
		ArrayList<String> listado = new ArrayList<String>();
		if (cuartel.isEmpty()) {
			throw new ExceptionEstaVacio("El cuartel esta vacio no se puede listar");
		} else {
			for (int i = 0; i < cuartel.size(); i++) {
				unidad = cuartel.get(i);
				listado.add(unidad.toString());
			}
		}
		
		return listado;
	}
	

}
