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
	
	public Infanteria() { // SE VA A UTILIZAR PARA CREAR UNA INFANTERIA A PARTIR DE UN JSonObject
		super();
		bonusDisponible = false;
	}

	@Override
	public JSONObject toJsonObject() throws JSONException {
		
		JSONObject jsonObject = super.toJsonObject();
		
		jsonObject.put("Bonus Disponible", bonusDisponible);

		return jsonObject;
	}
	
	@Override
	public void decodeJsonObject(JSONObject jsonObject) throws JSONException {
		super.decodeJsonObject(jsonObject);
		
		setBonusDisponible(jsonObject.getBoolean("Bonus Disponible")); 
	}
		

	// -------GETTERS----//

	public boolean getBonusDisponible() {
		return bonusDisponible;
	}
	
	// -------SETTERS----//
	
	public void setBonusDisponible(boolean bonusDisponible) {
		this.bonusDisponible = bonusDisponible;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}

}
