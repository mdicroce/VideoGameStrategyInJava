package Unidades;

public class Arquero extends Unidad implements IAccionesUnidades {

	public Arquero(byte propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Arquero", 11, 10, 4, propiedad, 1);
	}

	@Override
	public void bonusUnidad() {

	}

}
