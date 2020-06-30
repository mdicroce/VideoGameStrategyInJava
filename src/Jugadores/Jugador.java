package Jugadores;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase Jugadores la cual posee una contenedor generico  llamado cuartel el cual posee unidades 
 * 
 * 
 * @author Nahuel Flores
 *
 */

import Unidades.Unidad;

/**
 * Clase Jugador que coniene un Contenedor Generico llamado cuartel que contiene Unidades.
 * En esta clase se puede sumar oro al jugador, restar oro al jugador, convertir la clase a un JSONObject.
 * @author Nahue
 *
 */

public class Jugador {
	
	private String name;

	private int idPlayer;
	
	private float oro;

	private int limiteYMayor;
	
	private int limiteYMenor;
	
	private boolean turno;
	
	private Cuartel<Unidad> cuartel;
	
	
	
	public Jugador () {
		name = "";
		
		idPlayer = 0;
		
		oro = 0;
		
		limiteYMayor = -1;
		
		limiteYMenor = -1;
		
		turno = false;
		
		cuartel = new Cuartel<Unidad>();
	}

	public Jugador (String name,int idPlayer,float oro,int limiteYMayor,int limiteYMenor) {
		this.name = name;
		
		this.idPlayer = idPlayer;
		
		this.oro = oro;
		
		this.limiteYMayor = limiteYMayor;
		
		this.limiteYMenor = limiteYMenor;
		
		turno = false;
		
		cuartel = new Cuartel<Unidad>();
	}

// -------------------------------------GETTERS--------------------------------------------//
	
	public String getName() {
		return name;
	}

	public int getIdPlayer() {
		return idPlayer;
	}
	
	public float getOro() {
		return oro;
	}
	
	public int getLimiteYMayor() {
		return limiteYMayor;
	}
	
	public int getLimiteYMenor() {
		return limiteYMenor;
	}
	
	public Cuartel<Unidad> getCuartel() {
		return cuartel;
	}
	
// -------------------------------------SETTERS--------------------------------------------//		
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}
	
	public void setOro(float oro) {
		this.oro = oro;
	}

	public void setLimiteYMayor(int limiteYMayor) {
		this.limiteYMayor = limiteYMayor;
	}

	public void setLimiteYMenor(int limiteYMenor) {
		this.limiteYMenor = limiteYMenor;
	}

	public void setCuartel(Cuartel<Unidad> cuartel) {
		this.cuartel = cuartel;
	}
	
// -------------------------------------METODOS PROPIOS-------------------------------------//

	public void restarOro(float cant) {
		oro = oro - cant;
	}
	
	public void sumarOro(float cant) {
		oro = oro + cant;
	}
	
	public JSONObject toJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Nombre", name);
		jsonObject.put("ID Jugador", idPlayer);
		jsonObject.put("Oro", oro);
		jsonObject.put("Limite Y Mayor", limiteYMayor);
		jsonObject.put("Limite Y Menor", limiteYMenor);
		jsonObject.put("Turno", turno);
		jsonObject.put("Cuartel", cuartel.toJsonArray());
		
	return jsonObject;	
	}
	
	//public void seleccionar();

	//public void cederTurno();

	//public void selecionarUnida ();

}

