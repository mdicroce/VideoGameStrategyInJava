package Unidades;

import Mapa.Celda;

public class Caballero extends Unidad {

	public Caballero(int propiedad,Celda celdi) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Caballero", 15, 11, 2, 10, 5, 5, propiedad, celdi);
		if (propiedad == 0) {
			super.pos1 = 8;
			super.pos2 = 18;
		} else {
			pos1 = 28;
			pos2 = 38;
		}
	}
	
	public Caballero() // SE VA A UTILIZAR PARA CREAR UN CABALLERO A PARTIR DE UN JSonObject
	{
		super();
	
	}

	@Override
	public int hashCode() {
		return 3;
	}

}
