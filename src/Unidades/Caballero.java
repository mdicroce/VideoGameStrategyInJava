package Unidades;

public class Caballero extends Unidad implements IAccionesUnidades {

	public Caballero(int propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Caballero", 15, 11, 2, 10, 5, 5, propiedad, 1);
		if (propiedad == 0) {
			super.pos1 = 7;
			super.pos2 = 17;
		}
		else {
			pos1 = 27; 
			pos2 = 37;
		}
	}

	@Override
	public void bonusUnidad(Unidad unidad) {

	}

	@Override
	public int hashCode() {
		return 3;
	}

}
