package Unidades;

import Mapa.Celda;

public class Arquero extends Unidad {

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
	
	public Arquero() { // SE VA A UTILIZAR PARA CREAR UN ARQUERO A PARTIR DE UN JSonObject
		super();
	}

	@Override
	public int hashCode() {
		return 2;
	}

}
