package Unidades;

public class Arquero extends Unidad implements IAccionesUnidades {

	public Arquero(int propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Arquero", 11, 10, 4, 5, 5, 5, propiedad, 1);
	}

	@Override
	public void bonusUnidad(Unidad unidad) {

	}

	@Override
	public int hashCode() {
		return 2;
	}

}
