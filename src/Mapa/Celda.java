package Mapa;

import org.json.JSONException;
import org.json.JSONObject;

import Unidades.Arquero;
import Unidades.Caballero;
import Unidades.Infanteria;
import Unidades.Unidad;

public class Celda { // PONGO LA CLASE CELDA SOLO PARA QUE VEAN UN POCO LO QUE HABIA HECHO, DESPUES
						// ME ADAPTO A LO QUE HIZO MATIAS
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

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public void quitarUnidadCelda(Celda celda) {
		celda.unidad = null;
		celda.ocupado = false;
	}

		
	public JSONObject  toJsonObject() throws JSONException {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Pos X", posX);
		jsonObject.put("Pos Y", posY);
		jsonObject.put("Ocupado", ocupado);
		if (unidad instanceof Infanteria) {//Esto se realiza ya que la infanteria tiene un toJson diferente
			Infanteria infanteria = (Infanteria) unidad;
			jsonObject.put("Unidad", infanteria.toJsonObject()); 
		}else {
			jsonObject.put("Unidad", unidad.toJsonObject());
		} 
		
		jsonObject.put("Tipo de Sprite", tipoDeSprite);
		
	return jsonObject;
	}


	
	public void decodeJsonObject(JSONObject jsonObject) throws JSONException {
		setPosX(jsonObject.getInt("Pos X"));
		setPosY(jsonObject.getInt("Pos Y"));
		setOcupado(jsonObject.getBoolean("Ocupado"));
		
		if (!jsonObject.isNull("Unidad")) {
			
			decodeUnidad(jsonObject.getJSONObject("Unidad"));
		}
		else {
			setUnidad(null);
		}
		
		setTipoDeSprite((byte) jsonObject.getInt("Tipo de Sprite"));//Revisar getByte
		
	}
	
	
	public void decodeUnidad(JSONObject unidadJsonObject) throws JSONException {
		
		String nombre = unidadJsonObject.getString("Nombre");
		
		if (nombre.compareToIgnoreCase("Arquero") == 1) {
			Arquero arquero = new Arquero();
			arquero.decodeJsonObject(unidadJsonObject);
			setUnidad(arquero);
			
		} else {
			if (nombre.compareToIgnoreCase("Caballero") == 1) {
				Caballero caballero = new Caballero();
				caballero.decodeJsonObject(unidadJsonObject);
				setUnidad(caballero);
				
			} else {
				Infanteria infanteria = new Infanteria();
				infanteria.decodeJsonObject(unidadJsonObject);
				setUnidad(infanteria);
				
			}
		}
		
	}	
		

	public void prueba () {
		this.unidad = new Infanteria(0,this);
		this.ocupado = true;

	}

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
	

	@Override
	public String toString() {
		return "[ " + posX + "] [" + posY + "]" + unidad.toString();
	}

	
}
