package Unidades;

import org.json.JSONException;
import org.json.JSONObject;

public class Infanteria extends Unidad {
	private boolean bonusDisponible; // EL SOLDADO SOLO PUEDE UTILIZAR EL BONUS POR UNICA VEZ

	public Infanteria(int propiedad) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Infanteria", 18, 8, 8, 3, 5, 5, propiedad);
		bonusDisponible = true;
		if (propiedad == 0) {
			super.pos1 = 8;
			super.pos2 = 18;
		} else {
			pos1 = 26;
			pos2 = 36;
		}
	}

	@Override
	public JSONObject toJson() throws JSONException {
		JSONObject jsonObject = super.toJson();

		jsonObject.put("Bonus Disponible", bonusDisponible);

		return jsonObject;
	}

	// -------GETTERS----//

	public boolean getBonusDisponible() {
		return bonusDisponible;
	}

	@Override
	public int hashCode() {
		return 1;
	}

}
