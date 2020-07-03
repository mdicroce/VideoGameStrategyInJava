package Unidades;

import Mapa.Celda;

/**
 * Esta clase extiende de la clase Unidad.
 * @author Lucas
 *
 */
public class Arquero extends Unidad {
	/**
	 * Constructor con parametros inicializados.
	 * @param propiedad Un int del que representa de quien es el arquero segun el id del jugador.
	 * @param posicion Objeto del tipo celda que representa la posicion donde se va a ubicar el aquero.
	 */
	public Arquero(int propiedad, Celda posicion) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Arquero", 11, 10, 4, 5, 5, 5, propiedad,posicion);
		if (propiedad == 0) {
			super.pos1 = 7;
			super.pos2 = 17;
		} else {
			pos1 = 29;
			pos2 = 39;
		}
	}
	
	/**
	 * Constructor vacio.
	 */
	public Arquero() { // SE VA A UTILIZAR PARA CREAR UN ARQUERO A PARTIR DE UN JSonObject
		super();
	}
	
	
	@Override
	public int hashCode() {
		return 2;
	}

}
