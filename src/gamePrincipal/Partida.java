package gamePrincipal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;

import GuardadoYCarga.JsonUtiles;
import Jugadores.Jugador;
import Unidades.Arquero;
import Unidades.Caballero;
import Unidades.Infanteria;


/**
 * Clase Partida que contiene 2 jugadores.
 * En esta clase se puede crear una nueva partida, cargar una partida vieja y guardar una partida.
 * @author Nahue
 *
 */
public class Partida {
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Partida(int cantOro){
		jugador1 = new Jugador("Jugador 1", 0, cantOro, 4 , 0);
		jugador2 = new Jugador("Jugador 2", 1, cantOro, 10 , 7);
	}
	
	public Partida(){
		jugador1 = new Jugador();
		jugador2 = new Jugador();
	}
	
	/**
	 * Te devuelve un jugador segun el id pasado por parametro.
	 * @param id del tipo int que represeta el id del jugador que se quiere que se devuelva.
	 * @return Objeto de la clase Jugador.
	 */
	public Jugador getJugadorPorId(int id) {
		if (id == jugador1.getIdPlayer()) {
			return jugador1;
		} else {
			return jugador2;
			}
	}
	
	/**
	 * Se cargan los cuarteles de los jugadores con nuevas unidades;
	 */
	public void crearNuevaPartida() {
		
		cargarNuevoCuartel(jugador1);
		cargarNuevoCuartel(jugador2);
		
	}
	
	/**
	 * Carga una partida a partir de un Archivo guardado.
	 * @param nombreArchi String que es el nombre del Archivo
	 */
	public void cargarPartida(String nombreArchi) {
		
		JSONArray jsonArray;
		
		
		try {
			jsonArray = new JSONArray(JsonUtiles.leer(nombreArchi));
			decodeJsonArray(jsonArray);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void pasarTurno() {
		if (jugador1.getTurno()) {
			jugador1.terminarTurno();
			jugador2.setTurno(true);
		}
		else 
		{
			jugador2.terminarTurno();
			jugador1.setTurno(true);
		}
		
	}
	
	/**
	 * Guarda una partida y utiliza como nombre la Fecha y hora y un Identificador al principio.
	 */
	public void guardarPartida() {
		
		String nombreArchi = "PG_"+obtenerFechaYHoraActual()+".json";
		
		JsonUtiles.grabar(toJsonArray(), nombreArchi);
	
	}
	
	/**
	 * Crea las unidades y las agrega a el cuartel. 
	 * @param jugador Jugador al que se le cargaran las unidades en su cuartel.
	 */
	public void cargarNuevoCuartel(Jugador jugador) {
		int idPlayer = jugador.getIdPlayer();
		
		for (int i = 0; i < 4; i++) {
			Arquero arquero = new Arquero(idPlayer, null);
			jugador.agregarUnidadAlCuartel(arquero);
		}
		
		for (int i = 0; i < 4; i++) {
			Infanteria infanteria = new Infanteria(idPlayer, null);
			jugador.agregarUnidadAlCuartel(infanteria);
		}
		
		for (int i = 0; i < 7; i++) {
			Caballero caballero = new Caballero(idPlayer, null);
			jugador.agregarUnidadAlCuartel(caballero);
		}
		

	}
	/**
	 * Esto devuelve el jugador que tiene el turno actualmente
	 * @return Jugador con turno activo.
	 */
	public Jugador getJugadorxTurno() {
		if(jugador1.getTurno()) {
			return jugador1;
		}
		else if(jugador2.getTurno()) {
			return jugador2;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Convierte la partida a un JSONArray.
	 * @return JSONArray creado a partir de la case Partida.
	 */
	public JSONArray toJsonArray() {
		JSONArray jsonArray = new JSONArray();
		
		try {
			jsonArray.put(jugador1.toJsonObject());
			jsonArray.put(jugador2.toJsonObject());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return jsonArray;
	}
	
	/**
	 * Settea los jugadores a partir del JSONArray que se pasa por parametro.
	 * @param jsonArray JSONArray con el que se cargaran los jugadores.
	 */
	public void decodeJsonArray(JSONArray jsonArray) {
		
		try {
			
			jugador1.decodeJsonObject(jsonArray.getJSONObject(0));
			jugador2.decodeJsonObject(jsonArray.getJSONObject(1));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Funcion que obtiene la Fecha y Hora actual.
	 * @return String que contiene Fecha y hora.
	 */
	public static String obtenerFechaYHoraActual() {
		String formato = "dd-MM-yyyy_HH:mm:ss";
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
		LocalDateTime ahora = LocalDateTime.now();
		return formateador.format(ahora);
	}
	
}
