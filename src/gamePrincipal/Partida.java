package gamePrincipal;

import org.json.JSONArray;
import org.json.JSONException;

import Jugadores.Jugador;
import Unidades.Arquero;
import Unidades.Caballero;
import Unidades.Infanteria;

public class Partida {
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Partida(int cantOro){
		jugador1 = new Jugador("Jugador 1", 1, cantOro, 4 , 0);
		jugador2 = new Jugador("Jugador 2", 2, cantOro, 10 , 7);
	}
	
	public Partida(){
		jugador1 = new Jugador();
		jugador2 = new Jugador();
	}
	
	
	public Jugador getJugadorPorId(int id) {
		if (id == jugador1.getIdPlayer()) {
			return jugador1;
		} else {
			return jugador2;
			}
	}
	
	
	public void crearNuevaPartida() {
		
		cargarNuevoCuartel(jugador1);
		cargarNuevoCuartel(jugador2);
		
	}
	
	public void cargarPartida() {
		JSONArray jsonArray = null;
		decodeJsonArray(jsonArray);
		
	}
	
	public void cargarNuevoCuartel(Jugador jugador) {
		int idPlayer = jugador.getIdPlayer();
		
		Arquero arquero1 = new Arquero(idPlayer, null);
		Arquero arquero2 = new Arquero(idPlayer, null);
		Arquero arquero3 = new Arquero(idPlayer, null);
		Arquero arquero4 = new Arquero(idPlayer, null);
		
		Infanteria infanteria1 = new Infanteria(idPlayer, null);
		Infanteria infanteria2= new Infanteria(idPlayer, null);
		Infanteria infanteria3 = new Infanteria(idPlayer, null);
		Infanteria infanteria4 = new Infanteria(idPlayer, null);
		
		Caballero caballero1 = new Caballero(idPlayer, null);
		Caballero caballero2 = new Caballero(idPlayer, null);
		Caballero caballero3 = new Caballero(idPlayer, null);
		Caballero caballero4 = new Caballero(idPlayer, null);
		Caballero caballero5 = new Caballero(idPlayer, null);
		Caballero caballero6 = new Caballero(idPlayer, null);
		Caballero caballero7 = new Caballero(idPlayer, null);
		
		jugador.agregarUnidadAlCuartel(arquero1);
		jugador.agregarUnidadAlCuartel(arquero2);
		jugador.agregarUnidadAlCuartel(arquero3);
		jugador.agregarUnidadAlCuartel(arquero4);
		
		jugador.agregarUnidadAlCuartel(infanteria1);
		jugador.agregarUnidadAlCuartel(infanteria2);
		jugador.agregarUnidadAlCuartel(infanteria3);
		jugador.agregarUnidadAlCuartel(infanteria4);
		
		jugador.agregarUnidadAlCuartel(caballero1);
		jugador.agregarUnidadAlCuartel(caballero2);
		jugador.agregarUnidadAlCuartel(caballero3);
		jugador.agregarUnidadAlCuartel(caballero4);
		jugador.agregarUnidadAlCuartel(caballero5);
		jugador.agregarUnidadAlCuartel(caballero6);
		jugador.agregarUnidadAlCuartel(caballero7);
		
	}
	
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
	
	public void decodeJsonArray(JSONArray jsonArray) {
		
		try {
			
			jugador1.decodeJsonObject(jsonArray.getJSONObject(0));
			jugador2.decodeJsonObject(jsonArray.getJSONObject(1));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
