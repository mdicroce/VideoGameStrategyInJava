package Unidades;

public class Infanteria extends Unidad implements IAccionesUnidades {

	public Infanteria(int propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Infanteria", 18, 8, 8, 3, propiedad, 1);
	}

	@Override
	public void bonusUnidad() {

	}

	@Override
	public int hashCode() {
		return 1;
	}

}
