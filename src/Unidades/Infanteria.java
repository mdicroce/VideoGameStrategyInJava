package Unidades;

public class Infanteria extends Unidad implements IAccionesUnidades {

	public Infanteria(byte propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Infanteria", 18, 8, 8, propiedad, 1);
	}

	@Override
	public void bonusUnidad() {

	}

}
