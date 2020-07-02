package Jugadores;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Mapa.Celda;
import Mapa.MapaTablero;
import Unidades.Arquero;
import Unidades.Caballero;
import Unidades.Infanteria;

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
	
	private double oro;

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

	public Jugador (String name,int idPlayer,double oro,int limiteYMayor,int limiteYMenor) {
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
	
	public double getOro() {
		return oro;
	}
	
	public int getLimiteYMayor() {
		return limiteYMayor;
	}
	
	public int getLimiteYMenor() {
		return limiteYMenor;
	}
	
	public boolean getTurno() {
		return turno;
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
	
	public void setOro(double oro) {
		this.oro = oro;
	}

	public void setLimiteYMayor(int limiteYMayor) {
		this.limiteYMayor = limiteYMayor;
	}

	public void setLimiteYMenor(int limiteYMenor) {
		this.limiteYMenor = limiteYMenor;
	}
	
	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	public void setCuartel(Cuartel<Unidad> cuartel) {
		this.cuartel = cuartel;
	}
	
// -------------------------------------METODOS PROPIOS-------------------------------------//

	public void restarOro(double cant) {
		oro = oro - cant;
	}
	
	public void sumarOro(double cant) {
		oro = oro + cant;
	}
	
	public JSONObject toJsonObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Nombre", name);
		jsonObject.put("ID Jugador", idPlayer);
		jsonObject.put("Oro", oro);
		jsonObject.put("Limite Y Mayor", limiteYMayor);
		jsonObject.put("Limite Y Menor", limiteYMenor);
		jsonObject.put("Turno", turno);
		jsonObject.put("Cuartel", toJsonArray());
		
	return jsonObject;	
	}
	
/**
 * Convierte el arreglo a un JSONArray.	
 * @return JSONArray construido a partir del ArrayList y todos sus elementos.
 * @throws JSONException es lanzada cuando ocurre un error con los puts del JSONArray.
 */

	public JSONArray toJsonArray() {
		JSONArray jsonArray = new JSONArray();
		Unidad unidad;
		int i = 0;

		while(cuartel.getValidos()>i) {
			
			
			try {
				unidad = cuartel.buscar(i);
				
				if (unidad instanceof Infanteria) {// Esto se realiza ya que la infanteria tiene un toJson diferente
					Infanteria infanteria = (Infanteria) unidad;
					jsonArray.put(i, infanteria.toJsonObject());
				} else {
					jsonArray.put(i, unidad.toJsonObject());
						}
			} catch (ExceptionNoExiste e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionEstaVacio e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i++;
		}

		return jsonArray;
	}
	
	
	public void decodeJsonObject(JSONObject jsonObject) throws JSONException {
		
		setName(jsonObject.getString("Nombre"));
		setIdPlayer(jsonObject.getInt("ID Jugador"));
		setOro(jsonObject.getDouble("Oro"));
		setLimiteYMayor(jsonObject.getInt("Limite Y Mayor"));
		setLimiteYMenor(jsonObject.getInt("Limite Y Menor"));
		setTurno(jsonObject.getBoolean("Turno"));
		
		decodeJsonArray(jsonObject.getJSONArray("Cuartel"));
	}
	
	public void decodeJsonArray(JSONArray jsonArray) {
		
		int i = 0;
		
		while (i<jsonArray.length()) {
			try {
				decodeUnidad(jsonArray.getJSONObject(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionNoSePudoAgregar e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
	}
	
	
	public void decodeUnidad(JSONObject unidadJsonObject) throws JSONException, ExceptionNoSePudoAgregar {
		
		String nombre = unidadJsonObject.getString("Nombre");
		
		if (nombre.compareToIgnoreCase("Arquero") == 1) {
			Arquero arquero = new Arquero();
			arquero.decodeJsonObject(unidadJsonObject);
			cuartel.agregar(arquero);
			
		} else {
			if (nombre.compareToIgnoreCase("Caballero") == 1) {
				Caballero caballero = new Caballero();
				caballero.decodeJsonObject(unidadJsonObject);
				cuartel.agregar(caballero);
				
			} else {
				Infanteria infanteria = new Infanteria();
				infanteria.decodeJsonObject(unidadJsonObject);
				cuartel.agregar(infanteria);
				
			}
		}
		
	}
	
	public void agregarUnidadAlCuartel(Unidad unidad) {
		
		try {
			cuartel.agregar(unidad);
		} catch (ExceptionNoSePudoAgregar e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void eliminarUnidadAlCuartel(Unidad eliminar) {
		
			try {
				cuartel.eliminar(eliminar);
			} catch (ExceptionNoExiste e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionEstaVacio e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	

	public void buscarUnidadAlCuartel(Unidad buscar) {
		
		try {
			cuartel.buscar(buscar);
		} catch (ExceptionNoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionEstaVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void buscarUnidadAlCuartel(Celda posicion) {
		
		try {
			cuartel.buscar(posicion);
		} catch (ExceptionNoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionEstaVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void buscarUnidadAlCuartel(int pos) {
		
		try {
			cuartel.buscar(pos);
		} catch (ExceptionNoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionEstaVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void seleccionar(MapaTablero mapita)
	{
		
	}

	public void terminarTurno() {
		turno = false;
	}

	//public void selecionarUnida ();

}

