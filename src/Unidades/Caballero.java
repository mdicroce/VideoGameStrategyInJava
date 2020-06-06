package Unidades;

public class Caballero extends Unidad implements IAccionesUnidades {

	public Caballero(int propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Caballero", 15, 11, 2, 10, propiedad, 1);
	}

	@Override
	public void bonusUnidad() {

	}

	@Override
	public int hashCode() {
		return 3;
	}

}
