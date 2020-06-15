package Unidades;

public class Infanteria extends Unidad implements IAccionesUnidades {

	public Infanteria(int propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Infanteria", 18, 8, 8, 3, 5, 5, propiedad, 1);

	}

	// -------GETTERS----//

	@Override
	public void bonusUnidad(Unidad unidad) {

	}

	@Override
	public int hashCode() {
		return 1;
	}

}
