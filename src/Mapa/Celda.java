package Mapa;

/**
 * Clase que sirve para delimitar y crear los espacios en el mapa donde las unidades pueden insertarse y moverse a través de ellas.
 * 
 * @author Lucas
 */

import org.json.JSONException;
import org.json.JSONObject;

import Unidades.Unidad;

public class Celda {

	private int posX;
	private int posY;
	private boolean ocupado;
	private Unidad unidad;
	private byte tipoDeSprite;

	/**
	 * 
	 * @param posX         Posicion de la celda en el eje X
	 * @param posY         Posicion de la celda en el eje Y
	 * @param tipoDeSprite Pasto 0 = 0, Pasto 1 = 1, Pasto 2 = 2, bosque = 3,
	 *                     Montaña = 4, capital = 5.
	 */
	public Celda(int posX, int posY, byte tipoDeSprite) {
		this.posX = posX;
		this.posY = posY;
		ocupado = false;
		unidad = null;
		this.tipoDeSprite = tipoDeSprite;
	}

	public Celda() { // SE VA A UTILIZAR PARA CREAR UNA CELDA A PARTIR DE UN JSonObject
		this.posX = -1;
		this.posY = -1;
		ocupado = false;
		unidad = null;
		this.tipoDeSprite = -1;
	}

	// ---------------------------METODOSPROPIOS------------------------------//

	/**
	 * Quita la unidad en la posición en la que se encontraba y pasa la celda a
	 * estar libre.
	 * 
	 * @param celda Celda de donde se quiere quitar la unidad
	 */

	public void quitarUnidadCelda(Celda celda) {
		celda.unidad = null;
		celda.ocupado = false;
	}

	/**
	 * Convierte la Celda a un JSONObject.
	 * 
	 * @return construido a partir de la Celda.
	 * @throws JSONException es lanzada cuando ocurre un error con los puts del
	 *                       JSONObject.
	 */
	public JSONObject toJsonObject() throws JSONException {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("Pos X", posX);
		jsonObject.put("Pos Y", posY);
		jsonObject.put("Ocupado", ocupado);
		// no se guarda la unidad ya que la celda esta dentro de la misma.
		jsonObject.put("Tipo de Sprite", tipoDeSprite);

		return jsonObject;
	}

	/**
	 * Settea la Celda a partir del JSONObject pasado por parametro.
	 * 
	 * @param jsonObject Un JSONObject por parametro que se va a utilizar para
	 *                   settear la Celda.
	 * @throws JSONException es lanzada cuando ocurre un error con los gets del
	 *                       JSONObject.
	 */
	public void decodeJsonObject(JSONObject jsonObject) throws JSONException {
		setPosX(jsonObject.getInt("Pos X"));
		setPosY(jsonObject.getInt("Pos Y"));
		setOcupado(jsonObject.getBoolean("Ocupado"));

		setUnidad(null);// Esto se realiza ya que si Ocupado es tru luego se usara el set para colocar
						// la unidad y no crear una nueva que no este enlazada y si ocupado es false
						// queda en null

		setTipoDeSprite((byte) jsonObject.getInt("Tipo de Sprite"));// Revisar getByte

	}

	/*
	 * public void prueba2() { this.unidad = new Arquero(0, this); this.ocupado =
	 * true; }
	 * 
	 * public void prueba3() { this.unidad = new Caballero(0, this); this.ocupado =
	 * true; }
	 */
	// ---------------------------GETTERS-----------------------------------//
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Unidad getUnidadCelda() {
		return unidad;
	}

	public boolean getOcupado() {
		return ocupado;
	}

	public byte getTipoDeSprite() {
		return tipoDeSprite;
	}

	// ---------------------------SETTERS-----------------------------------//

	public Unidad getUnidad() {
		return unidad;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setTipoDeSprite(byte tipoDeSprite) {
		this.tipoDeSprite = tipoDeSprite;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		return "[ " + posX + "] [" + posY + "]" + unidad.toString();
	}

	@Override
	public boolean equals(Object obj) {
		boolean bandera = false;
		if (obj instanceof Celda) {
			Celda aux = (Celda) obj;
			if (aux.getPosX() == this.getPosX() && aux.getPosY() == this.getPosY()) {
				bandera = true;
			}
		}
		return bandera;
	}

}
