package Unidades;

public class Caballero extends Unidad {

	public Caballero(int propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Caballero", 15, 11, 2, 10, 5, 5, propiedad);
		if (propiedad == 0) {
			super.pos1 = 7;
			super.pos2 = 17;
		} else {
			pos1 = 27;
			pos2 = 37;
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
