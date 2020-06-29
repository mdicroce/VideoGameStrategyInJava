package Unidades;

public class Arquero extends Unidad {

	public Arquero(int propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Arquero", 11, 10, 4, 5, 5, 5, propiedad);
		if (propiedad == 0) {
			super.pos1 = 6;
			super.pos2 = 16;
		} else {
			pos1 = 28;
			pos2 = 38;
		}
	}

	@Override
	public int hashCode() {
		return 2;
	}

}
