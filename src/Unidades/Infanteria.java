package Unidades;

import org.json.JSONException;
import org.json.JSONObject;

import Mapa.Celda;

public class Infanteria extends Unidad {
	private boolean bonusDisponible; // EL SOLDADO SOLO PUEDE UTILIZAR EL BONUS POR UNICA VEZ

	public Infanteria(int propiedad, Celda celdi) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Infanteria", 18, 8, 8, 3, 5, 5, propiedad,celdi);
		bonusDisponible = true;
		if (propiedad == 0) {
			super.pos1 = 9;
			super.pos2 = 19;
		} else {
			pos1 = 27;
			pos2 = 37;
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
