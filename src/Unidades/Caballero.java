package Unidades;

public class Caballero extends Unidad implements IAccionesUnidades {

	public Caballero(byte propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Caballero", 15, 11, 2, propiedad, 1);
	}

	@Override
	public void bonusUnidad() {

	}

}
