package Unidades;

import Mapa.Celda;

/**
 * Esta clase extiende de la clase Unidad.
 * @author Lucas
 *
 */
public class Caballero extends Unidad {

	/**
	 * Constructor con parametros inicializados.
	 * @param propiedad Un int del que representa de quien es el caballero segun el id del jugador.
	 * @param celda Objeto del tipo celda que representa la posicion donde se va a ubicar el caballero.
	 */
	
	public Caballero(int propiedad, Celda posicion) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Caballero", 15, 11, 2, 10, 5, 5, propiedad, posicion);
		if (propiedad == 0) {
			super.pos1 = 8;
			super.pos2 = 18;
		} else {
			pos1 = 28;
			pos2 = 38;
		}
	}
	
	/**
	 * Constructor vacio.
	 */
	public Caballero() // SE VA A UTILIZAR PARA CREAR UN CABALLERO A PARTIR DE UN JSonObject
	{
		super();

	}

	@Override
	public int hashCode() {
		return 3;
	}

}
