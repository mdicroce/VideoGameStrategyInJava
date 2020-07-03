package Unidades;

import org.json.JSONException;
import org.json.JSONObject;

import Mapa.Celda;

/**
 * Esta clase extiende de la clase Unidad y posee un nuevo atributo que representa si la Infanteria tiene su bonusDisponible.
 * @author Lucas
 *
 */
public class Infanteria extends Unidad {
	private boolean bonusDisponible; // EL SOLDADO SOLO PUEDE UTILIZAR EL BONUS POR UNICA VEZ

	/**
	 * Constructor con parametros inicializados.
	 * @param propiedad Un int del que representa de quien la infanteria segun el id del jugador.
	 * @param celda Objeto del tipo celda que representa la posicion donde se va a ubicar a la infanteria.
	 */
	public Infanteria(int propiedad, Celda posicion) // SE PASA A QUE JUGADOR PERTENECE
	{
		super("Infanteria", 18, 8, 8, 3, 5, 5, propiedad, posicion);
		bonusDisponible = true;
		if (propiedad == 0) {
			super.pos1 = 9;
			super.pos2 = 19;
		} else {
			pos1 = 27;
			pos2 = 37;
		}
	}
	
	/**
	 * Constructor vacio.
	 */
	public Infanteria() { // SE VA A UTILIZAR PARA CREAR UNA INFANTERIA A PARTIR DE UN JSonObject
		super();
		bonusDisponible = false;
	}
	
	/**
	 * Convierte a la infanteria a un JSONObject utilizando el toJsonObject de la unidad.
	 * @return Un JSONObject construido a partir de todos los elementos la clase Infanteria.
	 * @throws JSONException es lanzada cuando ocurre un error con los puts del JSONObject.
	 */
	@Override
	public JSONObject toJsonObject() throws JSONException {

		JSONObject jsonObject = super.toJsonObject();

		jsonObject.put("Bonus Disponible", bonusDisponible);

		return jsonObject;
	}
	
	/**
	 * Settea los atributos de la clase Infanteria a partir de un JSONObject y la utilizacion de los Setters y utilizando el decodeJsonObject de la unidad. 
	 * @param jsonObject Un JSONObject por parametro que se va a utilizar para settear la Infanteria.
	 * @throws JSONException es lanzada cuando ocurre un error con los gets del JSONObject.
	 */
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
